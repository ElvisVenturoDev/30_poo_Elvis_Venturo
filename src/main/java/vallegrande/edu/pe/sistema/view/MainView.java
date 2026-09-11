package vallegrande.edu.pe.sistema.view;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class MainView extends BorderPane {

    private Button btnInicio, btnUsuarios, btnProductos;
    private Button btnReportes, btnConfiguracion, btnCitas;

    // Estilos CSS tipo iOS Glassmorphism
    private final String GLASS_CARD_STYLE =
            "-fx-background-color: rgba(255, 255, 255, 0.45);" +
                    "-fx-background-radius: 20px;" +
                    "-fx-border-color: rgba(255, 255, 255, 0.6);" +
                    "-fx-border-radius: 20px;" +
                    "-fx-border-width: 1.5px;" +
                    "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.08), 15, 0, 0, 8);";

    private final String BUTTON_STYLE =
            "-fx-background-color: rgba(255, 255, 255, 0.25);" +
                    "-fx-text-fill: white;" +
                    "-fx-font-size: 14px;" +
                    "-fx-font-weight: bold;" +
                    "-fx-background-radius: 14px;" +
                    "-fx-border-color: rgba(255, 255, 255, 0.3);" +
                    "-fx-border-radius: 14px;";

    public MainView() {
        // Fondo con degradado fluido tipo Apple
        this.setStyle("-fx-background-color: linear-gradient(to bottom right, #007AFF, #5856D6, #FF2D55);");
        crearMenu();
        mostrarInicio();
    }

    private void crearMenu() {
        VBox menu = new VBox(12);
        menu.setPadding(new Insets(20));
        menu.setPrefWidth(230);

        // Estilo Glassmorphic para el sidebar lateral
        menu.setStyle(
                "-fx-background-color: rgba(255, 255, 255, 0.15);" +
                        "-fx-background-radius: 0 25 25 0;" +
                        "-fx-border-color: rgba(255, 255, 255, 0.2);" +
                        "-fx-border-width: 0 1 0 0;"
        );

        Label titulo = new Label(" MI SISTEMA");
        titulo.setStyle("-fx-font-size: 22px; -fx-font-weight: 800; -fx-text-fill: white;");

        btnInicio = crearBoton("🏠  Inicio");
        btnUsuarios = crearBoton("👤  Usuarios");
        btnProductos = crearBoton("📦  Productos");
        btnReportes = crearBoton("📊  Reportes");
        btnConfiguracion = crearBoton("⚙️  Ajustes");
        btnCitas = crearBoton("📅  Citas");

        menu.getChildren().addAll(titulo, btnInicio, btnUsuarios, btnProductos, btnReportes, btnConfiguracion, btnCitas);
        setLeft(menu);
    }

    private Button crearBoton(String texto) {
        Button boton = new Button(texto);
        boton.setPrefWidth(190);
        boton.setPrefHeight(44);
        boton.setStyle(BUTTON_STYLE);

        // Efectos Hover tipo iOS Touch
        boton.setOnMouseEntered(e -> {
            boton.setStyle(BUTTON_STYLE + "-fx-background-color: rgba(255, 255, 255, 0.45);");
            animarPulsacion(boton, 1.03);
        });
        boton.setOnMouseExited(e -> {
            boton.setStyle(BUTTON_STYLE);
            animarPulsacion(boton, 1.0);
        });

        return boton;
    }

    // Método para animar el cambio de pantalla (Efecto suavizado iOS)
    private void cambiarVistaAnimada(Node nuevaVista) {
        nuevaVista.setOpacity(0);
        nuevaVista.setScaleX(0.95);
        nuevaVista.setScaleY(0.95);

        setCenter(nuevaVista);

        FadeTransition fade = new FadeTransition(Duration.millis(250), nuevaVista);
        fade.setToValue(1.0);

        ScaleTransition scale = new ScaleTransition(Duration.millis(250), nuevaVista);
        scale.setToX(1.0);
        scale.setToY(1.0);

        ParallelTransition animacion = new ParallelTransition(fade, scale);
        animacion.play();
    }

    private void animarPulsacion(Node nodo, double escala) {
        ScaleTransition st = new ScaleTransition(Duration.millis(120), nodo);
        st.setToX(escala);
        st.setToY(escala);
        st.play();
    }

    public void mostrarInicio() {
        VBox contenido = new VBox(15);
        contenido.setAlignment(Pos.CENTER);

        Label titulo = new Label("Bienvenido");
        titulo.setStyle("-fx-font-size: 32px; -fx-font-weight: 800; -fx-text-fill: white;");

        Label texto = new Label("Panel con diseño Liquid Glass & iOS Style");
        texto.setStyle("-fx-font-size: 16px; -fx-text-fill: rgba(255, 255, 255, 0.8);");

        contenido.getChildren().addAll(titulo, texto);
        cambiarVistaAnimada(contenido);
    }

    public void mostrarUsuarios() {
        VBox contenido = crearContenedorBase("USUARIOS");
        HBox tarjetas = new HBox(15);
        tarjetas.getChildren().addAll(
                crearTarjeta("Carlos Perez", "Administrador"),
                crearTarjeta("Maria Lopez", "Vendedora"),
                crearTarjeta("Piero Ramos", "Supervisor")
        );
        contenido.getChildren().add(tarjetas);
        cambiarVistaAnimada(contenido);
    }

    public void mostrarProductos() {
        VBox contenido = crearContenedorBase("PRODUCTOS");
        HBox tarjetas = new HBox(15);
        tarjetas.getChildren().addAll(
                crearTarjeta("MacBook Pro", "S/ 6,500"),
                crearTarjeta("iPhone 15 Pro", "S/ 4,800"),
                crearTarjeta("AirPods Pro", "S/ 980")
        );
        contenido.getChildren().add(tarjetas);
        cambiarVistaAnimada(contenido);
    }

    public void mostrarReportes() {
        VBox contenido = crearContenedorBase("REPORTES");
        HBox tarjetas = new HBox(15);
        tarjetas.getChildren().addAll(
                crearTarjeta("Ventas Mensuales", "S/ 45,200"),
                crearTarjeta("Crecimiento", "+18.5%"),
                crearTarjeta("Satisfacción", "99.2%")
        );
        contenido.getChildren().add(tarjetas);
        cambiarVistaAnimada(contenido);
    }

    public void mostrarConfiguracion() {
        VBox contenido = crearContenedorBase("AJUSTES");
        HBox tarjetas = new HBox(15);
        tarjetas.getChildren().addAll(
                crearTarjeta("Perfil Apple ID", "Activo"),
                crearTarjeta("Privacidad", "Estricta"),
                crearTarjeta("Apariencia", "Liquid Glass")
        );
        contenido.getChildren().add(tarjetas);
        cambiarVistaAnimada(contenido);
    }

    public void mostrarCitas() {
        VBox contenido = crearContenedorBase("CITAS");
        HBox tarjetas = new HBox(15);
        tarjetas.getChildren().addAll(
                crearTarjeta("Reunión de Equipo", "09:00 AM"),
                crearTarjeta("Demo de Cliente", "02:30 PM"),
                crearTarjeta("Revisión Mensual", "05:00 PM")
        );
        contenido.getChildren().add(tarjetas);
        cambiarVistaAnimada(contenido);
    }

    private VBox crearContenedorBase(String tituloTexto) {
        VBox contenido = new VBox(20);
        contenido.setPadding(new Insets(40));
        Label titulo = new Label(tituloTexto);
        titulo.setStyle("-fx-font-size: 28px; -fx-font-weight: 800; -fx-text-fill: white;");
        contenido.getChildren().add(titulo);
        return contenido;
    }

    private VBox crearTarjeta(String titulo, String detalle) {
        VBox tarjeta = new VBox(10);
        tarjeta.setPadding(new Insets(20));
        tarjeta.setPrefWidth(200);
        tarjeta.setStyle(GLASS_CARD_STYLE);

        Label nombre = new Label(titulo);
        nombre.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: #1C1C1E;");

        Label info = new Label(detalle);
        info.setStyle("-fx-font-size: 14px; -fx-text-fill: #3A3A3C;");

        tarjeta.getChildren().addAll(nombre, info);

        // Animación sutil de levitación al pasar el cursor sobre la tarjeta
        tarjeta.setOnMouseEntered(e -> animarPulsacion(tarjeta, 1.05));
        tarjeta.setOnMouseExited(e -> animarPulsacion(tarjeta, 1.0));

        return tarjeta;
    }

    // Getters
    public Button getBtnInicio() { return btnInicio; }
    public Button getBtnUsuarios() { return btnUsuarios; }
    public Button getBtnProductos() { return btnProductos; }
    public Button getBtnReportes() { return btnReportes; }
    public Button getBtnConfiguracion() { return btnConfiguracion; }
    public Button getBtnCitas() { return btnCitas; }
}