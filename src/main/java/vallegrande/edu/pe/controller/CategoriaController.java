package vallegrande.edu.pe.controller;

import vallegrande.edu.pe.model.Categoria;
import java.util.ArrayList;

public class CategoriaController {

    private final ArrayList<Categoria> categorias;

    public CategoriaController() {
        categorias = new ArrayList<>();
    }

    public void agregarCategoria(Categoria categoria) {
        categorias.add(categoria);
        System.out.println("Categoria registrada correctamente");
    }

    public void listarCategorias() {
        if (categorias.isEmpty()) {
            System.out.println("No hay Categorias registradas");
            return;
        }
        System.out.println("LISTA DE CATEGORIAS");
        for (Categoria categoria : categorias) {
            // Asegúrate de que este método exista en Categoria.java
            categoria.mostrarCategoria();
        }
    }

    public void buscarCategorias(String criterio) {
        boolean encontrado = false;
        String texto = criterio.toLowerCase();

        for (Categoria categoria : categorias) {
            if (categoria.getName().toLowerCase().contains(texto) ||
                    categoria.getDescription().toLowerCase().contains(texto)) {
                categoria.mostrarCategoria();
                encontrado = true;
            }
        }

        // Se evalúa AFUERA del bucle for
        if (!encontrado) {
            System.out.println("No se encontro ninguna Categoria");
        }
    }
}