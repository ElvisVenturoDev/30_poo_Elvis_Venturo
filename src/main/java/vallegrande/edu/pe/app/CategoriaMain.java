package vallegrande.edu.pe.app;

import vallegrande.edu.pe.controller.CategoriaController;
import vallegrande.edu.pe.model.Categoria;
import vallegrande.edu.pe.view.CategoriaView;

import java.util.Scanner;

public class CategoriaMain {
    public static void main(String[] args) {
        CategoriaController controller = new CategoriaController();
        CategoriaView view = new CategoriaView();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        view.mostrarName();

        do {
            view.mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Nombre: ");
                    String name = scanner.nextLine();

                    System.out.print("Descripción: ");
                    String description = scanner.nextLine();

                    if (name.trim().isEmpty() || description.trim().isEmpty()) {
                        view.mostrarMensaje("Error: Nombre y descripción no pueden estar vacíos.");
                    } else {
                        Categoria categoria = new Categoria(id, name, description);
                        controller.agregarCategoria(categoria);
                    }
                    break;

                case 2:
                    controller.listarCategorias();
                    break;

                case 3:
                    System.out.print("Ingrese nombre o descripción a buscar: ");
                    String criterio = scanner.nextLine();
                    controller.buscarCategorias(criterio);
                    break;

                case 4:
                    view.mostrarMensaje("Saliendo del módulo de categorías...");
                    break;

                default:
                    view.mostrarMensaje("Opción no válida.");
            }
        } while (opcion != 4);

        scanner.close();
    }
}