import java.util.ArrayList;
import java.util.Scanner;

class Estudiante {
    int id;
    String nombre;

    Estudiante(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    void mostrar() {
        System.out.println("ID: " + id + " | Nombre: " + nombre);
    }
}

public class SistemaGestionEstudiantes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        boolean banderaSalir = false;
        int contadorEstudiantes = 0;

        while (!banderaSalir) {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Agregar estudiante");
            System.out.println("2. Mostrar lista");
            System.out.println("3. Buscar estudiante por ID");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Ingrese nombre: ");
                    String nombre = sc.nextLine();
                    estudiantes.add(new Estudiante(id, nombre));
                    contadorEstudiantes++;
                    System.out.println("✅ Estudiante agregado. Total: " + contadorEstudiantes);
                    break;

                case 2:
                    System.out.println("\n📋 Lista de estudiantes:");
                    if (estudiantes.isEmpty()) {
                        System.out.println("No hay estudiantes registrados.");
                    } else {
                        for (Estudiante e : estudiantes) {
                            e.mostrar();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Ingrese ID a buscar: ");
                    int buscarId = sc.nextInt();
                    sc.nextLine();
                    boolean encontrado = false;
                    for (Estudiante e : estudiantes) {
                        if (e.id == buscarId) {
                            System.out.println("✅ Estudiante encontrado:");
                            e.mostrar();
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("❌ Estudiante no encontrado.");
                    }
                    break;

                case 4:
                    banderaSalir = true;
                    System.out.println("👋 Saliendo del sistema...");
                    break;

                default:
                    System.out.println("⚠️ Opción inválida. Intente de nuevo.");
            }
        }
        sc.close();
    }
}
