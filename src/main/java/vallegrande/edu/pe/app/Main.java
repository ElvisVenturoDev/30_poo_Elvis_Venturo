package vallegrande.edu.pe.app;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import vallegrande.edu.pe.controller.BibliotecaController;
import vallegrande.edu.pe.model.Libro;
import vallegrande.edu.pe.view.BibliotecaView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");
        BibliotecaController controller = new BibliotecaController();
        BibliotecaView view = new BibliotecaView();
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            view.mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("ID:");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Titulo:");
                    String titulo = scanner.nextLine();
                    System.out.println("Autor:");
                    String autor = scanner.nextLine();
                    System.out.println("Año:");
                    int anio = scanner.nextInt();
                    scanner.nextLine();

                    //Validar datos
                    if (titulo.isEmpty() || autor.isEmpty() || anio <= 0) {
                        System.out.println("Datos no validos");
                    } else {
                        Libro libro = new Libro(id, titulo, autor, anio);
                        controller.agregarLibro(libro);
                    }
                    break;
                case 2:
                    controller.ListarLibros();
                    break;
                case 3:
                    System.out.println("Ingrese Titulo o Autor");
                    String criterio = scanner.nextLine();
                    controller.BuscarLibros(criterio);
                    break;
                case 4:
                    System.out.println("Hasta luego.");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        } while (opcion != 4);
        scanner.close();
    }

}