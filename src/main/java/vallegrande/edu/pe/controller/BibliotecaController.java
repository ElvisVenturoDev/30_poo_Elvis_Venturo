package vallegrande.edu.pe.controller;

import vallegrande.edu.pe.model.Libro;

import java.util.ArrayList;

public class BibliotecaController {

    //Lista donden almacenaremos nuestros libros
    private ArrayList<Libro> libros;

    //Constructor
    public BibliotecaController() {
        libros = new ArrayList<>();
    }

    //Registrar
    public void agregarLibro(Libro libro) {
        libros.add(libro);
        System.out.println("Libro registrado correctamente");
    }

    //Listar
    public void ListarLibros() {
        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados");
            return;
        }
        System.out.println("LISTA DE LIBROS");
        for (Libro libro : libros) {
            libro.mostrarLibro();
        }
    }

    //Buscar
    public void BuscarLibros(String criterio) {
        boolean encontrado = false;
        String texto = criterio.toLowerCase();
        for (Libro libro : libros) {
            if (libro.getTitulo().toLowerCase().contains(texto) ||
                    libro.getAutor().toLowerCase().contains(texto)) {
                libro.mostrarLibro();
                encontrado = true;
            }
            if (!encontrado) {
                System.out.println("No se encontro ningun libro");
            }
        }
    }
}