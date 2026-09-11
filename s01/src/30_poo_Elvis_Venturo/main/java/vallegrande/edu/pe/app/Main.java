package vallegrande.edu.pe.app;

import vallegrande.edu.pe.controller.AgendaController;
import vallegrande.edu.pe.model.Contacto;
import vallegrande.edu.pe.view.AngendaView;

import  java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Crear los componentes
        AgendaController controller = new AgendaController();
        AngendaView view = new AngendaView();

        Scanner scanner = new Scanner(System.in);

        view.mostrarTitulo();

        int opcion;

        do {

            System.out.println("\n===== MENU =====");
            System.out.println("1. Registrar contacto");
            System.out.println("2. Listar contactos");
            System.out.println("3. Buscar contacto");
            System.out.println("4. Eliminar contacto");
            System.out.println("5. Salir");
            System.out.print("Ingrese una opcion: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:

                    System.out.println("\n===== REGISTRAR CONTACTO =====");

                    System.out.print("Ingrese ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Ingrese nombres: ");
                    String nombres = scanner.nextLine();

                    System.out.print("Ingrese apellidos: ");
                    String apellidos = scanner.nextLine();

                    System.out.print("Ingrese direccion: ");
                    String direccion = scanner.nextLine();

                    System.out.print("Ingrese telefono: ");
                    String telefono = scanner.nextLine();

                    System.out.print("Ingrese correo: ");
                    String correo = scanner.nextLine();

                    Contacto nuevoContacto = new Contacto(
                            id,
                            nombres,
                            apellidos,
                            direccion,
                            telefono,
                            correo
                    );

                    controller.agregarContacto(nuevoContacto);

                    break;

                case 2:

                    controller.listarContactos();

                    break;

                case 3:

                    System.out.println("\n===== BUSCAR CONTACTO =====");

                    System.out.print("Ingrese el nombre a buscar: ");
                    String nombreBuscar = scanner.nextLine();

                    controller.buscarContacto(nombreBuscar);

                    break;

                case 4:

                    System.out.println("\n===== ELIMINAR CONTACTO =====");

                    System.out.print("Ingrese el ID del contacto a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    scanner.nextLine();

                    controller.eliminarContacto(idEliminar);

                    break;

                case 5:

                    System.out.println("Programa finalizado.");

                    break;

                default:

                    System.out.println("Opcion no valida.");

            }

        } while (opcion != 5);

        scanner.close();
    }
}