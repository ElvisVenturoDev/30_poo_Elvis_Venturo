module vallegrande.edu.pe.misistema {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens vallegrande.edu.pe.misistema to javafx.fxml;
    opens vallegrande.edu.pe.misistema.controller to javafx.fxml;
    opens vallegrande.edu.pe.misistema.view to javafx.fxml;

    // OBLIGATORIO: Permite a TableView leer las propiedades de Usuario
    opens vallegrande.edu.pe.misistema.model to javafx.base, javafx.fxml;

    exports vallegrande.edu.pe.misistema;
    exports vallegrande.edu.pe.misistema.controller;
    exports vallegrande.edu.pe.misistema.model;
    exports vallegrande.edu.pe.misistema.view;
}