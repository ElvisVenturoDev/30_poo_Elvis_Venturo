package vallgrande.edu.pe.demointerfaz.controller;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import vallgrande.edu.pe.demointerfaz.model.HotelModel;

public class HotelController {

    private static final String COLOR_VINO = "#4a1518";
    private static final String COLOR_VINO_HOVER = "#611c20";
    private static final String COLOR_CREMA = "#faf3ea";
    private static final String COLOR_NARANJA = "#c07a4a";
    private static final String COLOR_TEXTO_OSCURO = "#2b1a15";
    private static final String COLOR_TEXTO_GRIS = "#5a5049";
    private static final String COLOR_TEXTO_GRIS_CLARO = "#9a8f85";

    private final HotelModel model = new HotelModel();
    private final HBox root;

    public HotelController() {
        root = new HBox();
        root.getChildren().addAll(buildLeftPanel(), buildRightPanel());
        HBox.setHgrow(root.getChildren().get(1), Priority.ALWAYS);
    }

    public HBox getRoot() {
        return root;
    }

    // ===================== ACCIONES =====================
    public void onIniciarSesion() {
        mostrarInfo("Iniciar Sesión", "Aquí se abrirá el formulario de inicio de sesión.");
    }

    public void onRegistrarRestaurante() {
        mostrarInfo("Registrar Nuevo Restaurante", "Aquí se abrirá el formulario de registro.");
    }

    public void onGestionMesas() {
        mostrarInfo("Gestión de Mesas", "Módulo de gestión de mesas en construcción.");
    }

    public void onMenuDigital() {
        mostrarInfo("Menú Digital", "Módulo de menú digital en construcción.");
    }

    private void mostrarInfo(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    // ===================== PANEL IZQUIERDO =====================
    private AnchorPane buildLeftPanel() {
        AnchorPane panel = new AnchorPane();
        panel.setPrefWidth(420);
        panel.setStyle("-fx-background-color: " + COLOR_VINO + ";");

        Circle c1 = new Circle(230, 200, 110, Color.web("white", 0.15));
        Circle c2 = new Circle(360, 140, 28, Color.web("white", 0.20));
        Circle c3 = new Circle(380, 300, 45, Color.web("white", 0.15));
        Circle c4 = new Circle(95, 400, 85, Color.web("white", 0.12));

        Label badge = new Label("SABOR & ARTE · APP DESKTOP");
        badge.setTextFill(Color.web("#f0d9d0"));
        badge.setFont(Font.font("System", FontWeight.BOLD, 11));
        badge.setPadding(new Insets(6, 14, 6, 14));
        badge.setStyle("-fx-background-color: rgba(255,255,255,0.08);"
                + "-fx-background-radius: 20;"
                + "-fx-border-color: rgba(255,255,255,0.3);"
                + "-fx-border-radius: 20;");
        AnchorPane.setTopAnchor(badge, 30.0);
        AnchorPane.setLeftAnchor(badge, 30.0);

        Label quote = new Label(model.getFrase());
        quote.setTextFill(Color.web("#f0dcd6"));
        quote.setFont(Font.font("System", FontWeight.NORMAL, 13));
        quote.setStyle("-fx-font-style: italic;");
        quote.setWrapText(true);

        Button btnMesas = createOutlineLightButton("⛊  Gestión de Mesas");
        btnMesas.setOnAction(e -> onGestionMesas());

        Button btnMenu = createOutlineLightButton("📄  Menú Digital");
        btnMenu.setOnAction(e -> onMenuDigital());

        HBox bottomButtons = new HBox(12, btnMesas, btnMenu);

        VBox bottomBox = new VBox(18, quote, bottomButtons);
        AnchorPane.setLeftAnchor(bottomBox, 30.0);
        AnchorPane.setRightAnchor(bottomBox, 20.0);
        AnchorPane.setBottomAnchor(bottomBox, 30.0);

        panel.getChildren().addAll(c1, c2, c3, c4, badge, bottomBox);
        return panel;
    }

    private Button createOutlineLightButton(String text) {
        Button button = new Button(text);
        button.setFont(Font.font("System", 12));
        button.setPadding(new Insets(8, 14, 8, 14));
        String baseStyle = "-fx-text-fill: #f5e6e0;"
                + "-fx-background-color: rgba(255,255,255,0.06);"
                + "-fx-border-color: rgba(255,255,255,0.35);"
                + "-fx-border-radius: 6;"
                + "-fx-background-radius: 6;"
                + "-fx-cursor: hand;";
        String hoverStyle = baseStyle.replace("rgba(255,255,255,0.06)", "rgba(255,255,255,0.15)");
        button.setStyle(baseStyle);
        button.setOnMouseEntered(e -> button.setStyle(hoverStyle));
        button.setOnMouseExited(e -> button.setStyle(baseStyle));
        return button;
    }

    // ===================== PANEL DERECHO =====================
    private VBox buildRightPanel() {
        VBox panel = new VBox(14);
        panel.setAlignment(Pos.CENTER);
        panel.setPadding(new Insets(40));
        panel.setStyle("-fx-background-color: " + COLOR_CREMA + ";");
        HBox.setHgrow(panel, Priority.ALWAYS);

        Region accentLine = new Region();
        accentLine.setPrefSize(40, 3);
        accentLine.setStyle("-fx-background-color: " + COLOR_NARANJA + ";");

        Label titleMain = new Label("Sabor");
        titleMain.setFont(Font.font("Georgia", FontWeight.BOLD, 34));
        titleMain.setTextFill(Color.web(COLOR_TEXTO_OSCURO));

        Label titleAccent = new Label("&Arte");
        titleAccent.setFont(Font.font("Georgia", FontWeight.BOLD, 34));
        titleAccent.setTextFill(Color.web(COLOR_NARANJA));

        HBox titleBox = new HBox(titleMain, titleAccent);
        titleBox.setAlignment(Pos.CENTER);

        Label subtitle = new Label(model.getSubtitulo());
        subtitle.setFont(Font.font("System", FontWeight.BOLD, 11));
        subtitle.setTextFill(Color.web("#a05a3a"));
        subtitle.setStyle("-fx-letter-spacing: 2px;");

        Label description = new Label(model.getDescripcion());
        description.setFont(Font.font("System", 13));
        description.setTextFill(Color.web(COLOR_TEXTO_GRIS));
        description.setWrapText(true);
        description.setTextAlignment(TextAlignment.CENTER);
        description.setMaxWidth(420);

        Button btnIniciarSesion = new Button("Iniciar Sesión");
        stylePrimaryDarkButton(btnIniciarSesion);
        btnIniciarSesion.setMaxWidth(Double.MAX_VALUE);
        btnIniciarSesion.setOnAction(e -> onIniciarSesion());

        Button btnRegistrar = new Button("Registrar Nuevo Restaurante");
        styleOutlinePrimaryButton(btnRegistrar);
        btnRegistrar.setMaxWidth(Double.MAX_VALUE);
        btnRegistrar.setOnAction(e -> onRegistrarRestaurante());

        VBox buttonsBox = new VBox(12, btnIniciarSesion, btnRegistrar);
        buttonsBox.setAlignment(Pos.CENTER);
        buttonsBox.setMaxWidth(340);
        buttonsBox.setPadding(new Insets(14, 0, 14, 0));

        Label footer = new Label(model.getVersion());
        footer.setFont(Font.font("System", 10));
        footer.setTextFill(Color.web(COLOR_TEXTO_GRIS_CLARO));

        panel.getChildren().addAll(accentLine, titleBox, subtitle, description, buttonsBox, footer);
        return panel;
    }

    private void stylePrimaryDarkButton(Button button) {
        button.setFont(Font.font("System", FontWeight.BOLD, 13));
        button.setPadding(new Insets(12, 20, 12, 20));
        String baseStyle = "-fx-background-color: " + COLOR_VINO + ";"
                + "-fx-text-fill: white;"
                + "-fx-background-radius: 6;"
                + "-fx-cursor: hand;";
        String hoverStyle = "-fx-background-color: " + COLOR_VINO_HOVER + ";"
                + "-fx-text-fill: white;"
                + "-fx-background-radius: 6;"
                + "-fx-cursor: hand;";
        button.setStyle(baseStyle);
        button.setOnMouseEntered(e -> button.setStyle(hoverStyle));
        button.setOnMouseExited(e -> button.setStyle(baseStyle));
    }

    private void styleOutlinePrimaryButton(Button button) {
        button.setFont(Font.font("System", FontWeight.BOLD, 13));
        button.setPadding(new Insets(12, 20, 12, 20));
        String baseStyle = "-fx-background-color: transparent;"
                + "-fx-text-fill: " + COLOR_VINO + ";"
                + "-fx-border-color: " + COLOR_VINO + ";"
                + "-fx-border-radius: 6;"
                + "-fx-background-radius: 6;"
                + "-fx-cursor: hand;";
        String hoverStyle = "-fx-background-color: rgba(74,21,24,0.06);"
                + "-fx-text-fill: " + COLOR_VINO + ";"
                + "-fx-border-color: " + COLOR_VINO + ";"
                + "-fx-border-radius: 6;"
                + "-fx-background-radius: 6;"
                + "-fx-cursor: hand;";
        button.setStyle(baseStyle);
        button.setOnMouseEntered(e -> button.setStyle(hoverStyle));
        button.setOnMouseExited(e -> button.setStyle(baseStyle));
    }
}