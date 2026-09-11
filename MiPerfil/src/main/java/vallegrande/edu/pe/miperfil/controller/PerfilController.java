package vallegrande.edu.pe.miperfil.controller;

import vallegrande.edu.pe.miperfil.model.perfil;
import vallegrande.edu.pe.miperfil.view.PerfilView;

public class PerfilController {
    private PerfilView view;

    public PerfilController(PerfilView view) {
        this.view = view;
        this.view.getBtnMostrar().setOnAction(e -> mostrarPerfil());
    }

    private void mostrarPerfil() {
        String nombre = view.getTxtNombre().getText();
        String carrera = view.getTxtCarrera().getText();
        String semestre = view.getTxtSemestre().getText();
        String juego = view.getTxtJuego().getText();

        perfil perfilObj = new perfil(nombre, carrera, semestre, juego);

        view.getLblResultado().setText(perfilObj.obtenerPresentacion80());
    }
}