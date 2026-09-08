package vallgrande.edu.pe.demointerfaz.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class HotelView {

    private TextField txtUsuario;
    private PasswordField txtPassword;
    private Label lblError;
    private Button btnIngresar;

    public Scene getLoginScene() {
        Label titulo = new Label("Hotel Manager - Login");
        titulo.setStyle("-fx-font-size:20px; -fx-font-weight:bold;");

        txtUsuario = new TextField();
        txtUsuario.setPromptText("Usuario");

        txtPassword = new PasswordField();
        txtPassword.setPromptText("Contraseña");

        btnIngresar = new Button("Ingresar");

        lblError = new Label();
        lblError.setStyle("-fx-text-fill:red;");

        VBox root = new VBox(15, titulo, txtUsuario, txtPassword, btnIngresar, lblError);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(40));

        return new Scene(root, 400, 300);
    }

    public Scene getDashboardScene() {
        Label titulo = new Label("Hotel Manager");
        titulo.setStyle("-fx-font-size:22px; -fx-font-weight:bold;");
        titulo.setPadding(new Insets(15));

        Button btnReservas = new Button("Reservas");
        Button btnClientes = new Button("Clientes");
        Button btnHabitaciones = new Button("Habitaciones");
        btnReservas.setMaxWidth(Double.MAX_VALUE);
        btnClientes.setMaxWidth(Double.MAX_VALUE);
        btnHabitaciones.setMaxWidth(Double.MAX_VALUE);

        VBox menu = new VBox(10, btnReservas, btnClientes, btnHabitaciones);
        menu.setPadding(new Insets(15));

        Label contenido = new Label("Bienvenido al panel del Hotel");
        contenido.setPadding(new Insets(20));

        BorderPane root = new BorderPane();
        root.setTop(titulo);
        root.setLeft(menu);
        root.setCenter(contenido);

        return new Scene(root, 700, 450);
    }

    public TextField getTxtUsuario() { return txtUsuario; }
    public PasswordField getTxtPassword() { return txtPassword; }
    public Label getLblError() { return lblError; }
    public Button getBtnIngresar() { return btnIngresar; }
}