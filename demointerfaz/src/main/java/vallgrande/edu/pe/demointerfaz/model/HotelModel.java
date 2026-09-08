package vallgrande.edu.pe.demointerfaz.model;

public class HotelModel {

    private String nombreApp = "Sabor&Arte";
    private String subtitulo = "SISTEMA DE GESTIÓN GASTRONÓMICA";
    private String descripcion = "Bienvenido a tu plataforma integral para la gestión de "
            + "reservas, pedidos y experiencias gastronómicas. Eleva cada servicio al siguiente nivel.";
    private String frase = "\"Porque cada platillo cuenta una historia, y cada cliente merece vivirla.\"";
    private String version = "Sabor&Arte v1.0 · Taller Programación II · POO";

    public String getNombreApp() {
        return nombreApp;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getFrase() {
        return frase;
    }

    public String getVersion() {
        return version;
    }
}