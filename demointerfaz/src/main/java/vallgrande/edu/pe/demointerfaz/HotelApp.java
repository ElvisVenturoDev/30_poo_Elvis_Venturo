package vallgrande.edu.pe.demointerfaz;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import vallgrande.edu.pe.demointerfaz.controller.HotelController;

public class HotelApp extends Application {

    @Override
    public void start(Stage stage) {
        HotelController controller = new HotelController();

        Scene scene = new Scene(controller.getRoot(), 1000, 620);

        stage.setTitle("Sabor&Arte - Sistema de Gestión Gastronómica");
        stage.setScene(scene);
        stage.setMinWidth(900);
        stage.setMinHeight(560);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}