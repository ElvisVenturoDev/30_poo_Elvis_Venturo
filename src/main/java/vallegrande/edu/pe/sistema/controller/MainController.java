package vallegrande.edu.pe.sistema.controller;

import vallegrande.edu.pe.sistema.view.MainView;

public class MainController {

    private MainView view;

    public MainController(MainView view) {
        this.view = view;
        configurarEventos();
    }

    private void configurarEventos() {
        // Eventos de los botones principales
        view.getBtnInicio().setOnAction(e -> view.mostrarInicio());
        view.getBtnUsuarios().setOnAction(e -> view.mostrarUsuarios());
        view.getBtnProductos().setOnAction(e -> view.mostrarProductos());

        // Eventos de los 3 nuevos apartados
        view.getBtnReportes().setOnAction(e -> view.mostrarReportes());
        view.getBtnConfiguracion().setOnAction(e -> view.mostrarConfiguracion());
        view.getBtnCitas().setOnAction(e -> view.mostrarCitas());
    }
}