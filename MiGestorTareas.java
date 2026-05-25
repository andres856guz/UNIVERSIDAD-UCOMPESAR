import java.util.ArrayList;
import java.util.Scanner;

/**
 * Gestor de tareas pendientes.
 * Permite agregar, mostrar, marcar como completadas y contar tareas pendientes.
 */
public class MiGestorTareas {

    // Clase interna para representar una tarea
    static class Tarea {
        String descripcion;
        boolean completada;

        Tarea(String descripcion) {
            this.descripcion = descripcion;
            this.completada = false;
        }
    }

    /**
     * Función sin parámetros y con retorno.
     * Inicializa una lista de ejemplo con 3 tareas.
     * @return lista de tareas iniciales
     */
    public static ArrayList<Tarea> obtenerTareas() {
        ArrayList<Tarea> lista = new ArrayList<>();
        lista.add(new Tarea("Estudiar algoritmos"));
        lista.add(new Tarea("Hacer ejercicio"));
        lista.add(new Tarea("Leer capítulo de programación"));
        return lista;
    }

    /**
     * Función con parámetros y sin retorno.
     * Muestra las tareas numeradas, indicando si están completadas.
     * @param listaTareas lista de tareas
     */
    public static void mostrarTareas(ArrayList<Tarea> listaTareas) {
        System.out.println("\n--- Lista de Tareas ---");
        for (int i = 0; i < listaTareas.size(); i++) {
            Tarea t = listaTareas.get(i);
            String estado = t.completada ? "[X]" : "[ ]";
            System.out.println((i + 1) + ". " + estado + " " + t.descripcion);
        }
    }

    /**
     * Función con parámetros y con retorno.
     * Agrega una nueva tarea a la lista.
     * @param listaTareas lista de tareas
     * @param descripcion descripción de la nueva tarea
     * @return lista de tareas modificada
     */
    public static ArrayList<Tarea> agregarTarea(ArrayList<Tarea> listaTareas, String descripcion) {
        listaTareas.add(new Tarea(descripcion));
        return listaTareas;
    }

    /**
     * Función con parámetros y sin retorno.
     * Marca una tarea como completada según la posición indicada.
     * Maneja errores si la posición es inválida.
     * @param listaTareas lista de tareas
     * @param posicion índice de la tarea (1-based)
     */
    public static void marcarCompletada(ArrayList<Tarea> listaTareas, int posicion) {
        try {
            listaTareas.get(posicion - 1).completada = true;
            System.out.println("Tarea marcada como completada.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: posición inválida.");
        }
    }

    /**
     * Función recursiva con parámetros y con retorno.
     * Cuenta cuántas tareas están pendientes.
     * @param listaTareas lista de tareas
     * @param indice índice actual
     * @return número de tareas pendientes
     */
    public static int contarTareasPendientes(ArrayList<Tarea> listaTareas, int indice) {
        // Caso base
        if (indice == listaTareas.size()) {
            return 0;
        }
        // Caso recursivo
        if (!listaTareas.get(indice).completada) {
            return 1 + contarTareasPendientes(listaTareas, indice + 1);
        } else {
            return contarTareasPendientes(listaTareas, indice + 1);
        }
    }

    // Flujo principal con menú
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Tarea> listaTareas = obtenerTareas();

        int opcion;
        do {
            System.out.println("\n--- Menú Gestor de Tareas ---");
            System.out.println("1. Ver tareas");
            System.out.println("2. Agregar tarea");
            System.out.println("3. Marcar tarea como completada");
            System.out.println("4. Mostrar total de tareas pendientes");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    mostrarTareas(listaTareas);
                    break;
                case 2:
                    System.out.print("Descripción de la nueva tarea: ");
                    String desc = sc.nextLine();
                    agregarTarea(listaTareas, desc);
                    break;
                case 3:
                    System.out.print("Número de la tarea a marcar: ");
                    int pos = sc.nextInt();
                    marcarCompletada(listaTareas, pos);
                    break;
                case 4:
                    //Corrección: ahora imprime el resultado
                    int pendientes = contarTareasPendientes(listaTareas, 0);
                    System.out.println("Total de tareas pendientes: " + pendientes);
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 5);

        sc.close();
    }
}
