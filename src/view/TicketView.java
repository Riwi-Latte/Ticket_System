package view;

import controller.TicketController;
import java.util.Scanner;

public class TicketView {

    private TicketController controller;
    private Scanner scanner;

    public TicketView() {
        controller = new TicketController();
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion = 0;

        do {
            System.out.println("\n===============================");
            System.out.println("      GESTIÓN DE TICKETS");
            System.out.println("===============================");
            System.out.println("1. Crear Ticket");
            System.out.println("2. Buscar Ticket por ID");
            System.out.println("3. Actualizar Ticket");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
                continue;
            }

            switch (opcion) {
                case 1 -> crearTicket();
                case 2 -> buscarTicketPorId();
                case 3 -> actualizarTicket();
                case 4 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }

        } while (opcion != 4);
    }

  
    private void crearTicket() {
        System.out.println("\n CREAR NUEVO TICKET");

        System.out.print("Título: ");
        String titulo = scanner.nextLine();

        System.out.print("Descripción: ");
        String descripcion = scanner.nextLine();

        System.out.print("ID del usuario que reporta: ");
        int idUsuario = Integer.parseInt(scanner.nextLine());

        System.out.print("ID de la categoría: ");
        int idCategoria = Integer.parseInt(scanner.nextLine());

        controller.crearTicket(titulo, descripcion, idUsuario, idCategoria);
    }

    
    private void buscarTicketPorId() {
        System.out.println("\n BUSCAR TICKET POR ID");

        System.out.print("Ingrese el ID del ticket: ");
        int id = Integer.parseInt(scanner.nextLine());

        controller.buscarTicketPorId(id);
    }

    
    private void actualizarTicket() {
        System.out.println("\n ACTUALIZAR TICKET");

        System.out.print("Ingrese el ID del ticket: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Nuevo título: ");
        String nuevoTitulo = scanner.nextLine();

        System.out.print("Nueva descripción: ");
        String nuevaDescripcion = scanner.nextLine();

        System.out.print("Nuevo estado (Open, In Progress, Resolved, Closed): ");
        String nuevoEstado = scanner.nextLine();

        controller.actualizarTicket(id, nuevoTitulo, nuevaDescripcion, nuevoEstado);
    }
}
