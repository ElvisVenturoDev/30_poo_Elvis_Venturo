package vallegrande.edu.pe.misistema.view;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import vallegrande.edu.pe.misistema.model.Usuario;

import java.util.List;

public class MainView extends BorderPane {

    // Botones del Menú Lateral
    private Button btnInicio;
    private Button btnUsuarios;
    private Button btnNuevoUsuario;

    // Componentes de la Tabla
    private TableView<Usuario> tablaUsuarios;

    // Componentes del Formulario
    private TextField txtNombre;
    private TextField txtApellido;
    private TextField txtCorreo;
    private ComboBox<String> cbEstado;
    private Button btnGuardar;
    private Button btnLimpiar;

    // Paneles Centrales
    private StackPane contenedorCentral;
    private VBox vistaTabla;
    private VBox vistaFormulario;
    private Label vistaInicio;

    public MainView() {
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        // --- Menú Lateral ---
        VBox menuLateral = new VBox(10);
        menuLateral.setPadding(new Insets(15));
        menuLateral.setStyle("-fx-background-color: #f0f0f0;");
        menuLateral.setPrefWidth(160);

        btnInicio = new Button("Inicio");
        btnUsuarios = new Button("Usuarios");
        btnNuevoUsuario = new Button("Nuevo Usuario");

        btnInicio.setMaxWidth(Double.MAX_VALUE);
        btnUsuarios.setMaxWidth(Double.MAX_VALUE);
        btnNuevoUsuario.setMaxWidth(Double.MAX_VALUE);

        // Estilo especial para destacar el botón de agregar
        btnNuevoUsuario.setStyle("-fx-background-color: #007bff; -fx-text-fill: white; -fx-font-weight: bold;");

        menuLateral.getChildren().addAll(btnInicio, btnUsuarios, btnNuevoUsuario);
        this.setLeft(menuLateral);

        // --- Contenedor Central ---
        contenedorCentral = new StackPane();
        this.setCenter(contenedorCentral);

        crearVistaInicio();
        crearVistaTabla();
        crearVistaFormulario();

        mostrarInicio();
    }

    private void crearVistaInicio() {
        vistaInicio = new Label("Bienvenido al Sistema");
        vistaInicio.setStyle("-fx-font-size: 22px; -fx-font-weight: bold;");
    }

    private void crearVistaTabla() {
        tablaUsuarios = new TableView<>();

        TableColumn<Usuario, Integer> colId = new TableColumn<>("ID");
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Usuario, String> colNombre = new TableColumn<>("Nombre");
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));

        TableColumn<Usuario, String> colApellido = new TableColumn<>("Apellido");
        colApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));

        TableColumn<Usuario, String> colCorreo = new TableColumn<>("Correo");
        colCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));

        TableColumn<Usuario, String> colEstado = new TableColumn<>("Estado");
        colEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));

        tablaUsuarios.getColumns().addAll(colId, colNombre, colApellido, colCorreo, colEstado);
        tablaUsuarios.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        Label lblTitulo = new Label("Lista de Usuarios");
        lblTitulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        vistaTabla = new VBox(10, lblTitulo, tablaUsuarios);
        vistaTabla.setPadding(new Insets(15));
    }

    private void crearVistaFormulario() {
        GridPane grid = new GridPane();
        grid.setHgap(15);
        grid.setVgap(15);
        grid.setAlignment(Pos.CENTER_LEFT);

        txtNombre = new TextField();
        txtApellido = new TextField();
        txtCorreo = new TextField();
        cbEstado = new ComboBox<>(FXCollections.observableArrayList("Activo", "Inactivo"));
        cbEstado.getSelectionModel().selectFirst();

        btnGuardar = new Button("Guardar Usuario");
        btnGuardar.setStyle("-fx-background-color: #28a745; -fx-text-fill: white; -fx-font-weight: bold;");
        btnLimpiar = new Button("Limpiar");

        grid.add(new Label("Nombre:"), 0, 0);
        grid.add(txtNombre, 1, 0);
        grid.add(new Label("Apellido:"), 0, 1);
        grid.add(txtApellido, 1, 1);
        grid.add(new Label("Correo:"), 0, 2);
        grid.add(txtCorreo, 1, 2);
        grid.add(new Label("Estado:"), 0, 3);
        grid.add(cbEstado, 1, 3);

        HBox botones = new HBox(10, btnGuardar, btnLimpiar);
        grid.add(botones, 1, 4);

        Label lblTitulo = new Label("Registrar Nuevo Usuario");
        lblTitulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        vistaFormulario = new VBox(15, lblTitulo, grid);
        vistaFormulario.setPadding(new Insets(20));
    }

    // NAVEGACIÓN
    public void mostrarInicio() {
        contenedorCentral.getChildren().setAll(vistaInicio);
    }

    public void mostrarUsuarios() {
        contenedorCentral.getChildren().setAll(vistaTabla);
    }

    public void mostrarFormulario() {
        contenedorCentral.getChildren().setAll(vistaFormulario);
    }

    public void mostrarDatosUsuarios(List<Usuario> lista) {
        tablaUsuarios.setItems(FXCollections.observableArrayList(lista));
    }

    public void limpiarFormulario() {
        txtNombre.clear();
        txtApellido.clear();
        txtCorreo.clear();
        cbEstado.getSelectionModel().selectFirst();
    }

    // Getters
    public Button getBtnInicio() { return btnInicio; }
    public Button getBtnUsuarios() { return btnUsuarios; }
    public Button getBtnNuevoUsuario() { return btnNuevoUsuario; }
    public Button getBtnGuardar() { return btnGuardar; }
    public Button getBtnLimpiar() { return btnLimpiar; }
    public TextField getTxtNombre() { return txtNombre; }
    public TextField getTxtApellido() { return txtApellido; }
    public TextField getTxtCorreo() { return txtCorreo; }
    public ComboBox<String> getCbEstado() { return cbEstado; }
}