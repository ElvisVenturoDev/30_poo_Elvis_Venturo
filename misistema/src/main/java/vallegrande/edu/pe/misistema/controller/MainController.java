package vallegrande.edu.pe.misistema.controller;

import javafx.scene.control.Alert;
import vallegrande.edu.pe.misistema.model.Usuario;
import vallegrande.edu.pe.misistema.model.UsuarioDAO;
import vallegrande.edu.pe.misistema.view.MainView;

import java.util.List;

public class MainController {

    private MainView view;
    private UsuarioDAO usuarioDAO;

    public MainController(MainView view) {
        this.view = view;
        this.usuarioDAO = new UsuarioDAO();
        configurarEventos();
    }

    public void configurarEventos() {
        // Eventos del menú lateral
        view.getBtnInicio().setOnAction(e -> view.mostrarInicio());

        view.getBtnUsuarios().setOnAction(e -> {
            view.mostrarUsuarios();
            cargarUsuarios();
        });

        view.getBtnNuevoUsuario().setOnAction(e -> {
            view.limpiarFormulario();
            view.mostrarFormulario();
        });

        // Eventos del formulario
        view.getBtnGuardar().setOnAction(e -> registrarUsuario());
        view.getBtnLimpiar().setOnAction(e -> view.limpiarFormulario());
    }

    private void cargarUsuarios() {
        List<Usuario> usuarios = usuarioDAO.listar();
        view.mostrarDatosUsuarios(usuarios);
    }

    private void registrarUsuario() {
        String nombre = view.getTxtNombre().getText().trim();
        String apellido = view.getTxtApellido().getText().trim();
        String correo = view.getTxtCorreo().getText().trim();
        String estado = view.getCbEstado().getValue();

        if (nombre.isEmpty() || apellido.isEmpty() || correo.isEmpty()) {
            mostrarAlerta("Advertencia", "Por favor, complete todos los campos obligatorios.", Alert.AlertType.WARNING);
            return;
        }

        Usuario nuevoUsuario = new Usuario(nombre, apellido, correo, estado);
        boolean guardado = usuarioDAO.insertar(nuevoUsuario);

        if (guardado) {
            mostrarAlerta("Éxito", "Usuario registrado correctamente.", Alert.AlertType.INFORMATION);
            view.limpiarFormulario();

            // Redirige automáticamente a la tabla con los datos actualizados
            view.mostrarUsuarios();
            cargarUsuarios();
        } else {
            mostrarAlerta("Error", "No se pudo registrar el usuario en la base de datos.", Alert.AlertType.ERROR);
        }
    }

    private void mostrarAlerta(String titulo, String contenido, Alert.AlertType tipo) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(contenido);
        alerta.showAndWait();
    }
}