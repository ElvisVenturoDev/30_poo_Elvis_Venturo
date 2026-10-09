package vallegrande.edu.pe.sistemaproductores.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    // Revisa bien el puerto (3306 o 3307) y el nombre de la base de datos
    private static final String URL = "jdbc:mysql://localhost:3307/sistema_productores";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    public static Connection conectar() {
        try {
            Connection conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa a MySQL");
            return conexion;
        } catch (SQLException e) {
            System.out.println("Error al conectar con MySQL: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    // Método main para probar la conexión de forma independiente
    public static void main(String[] args) {
        conectar();
    }
}