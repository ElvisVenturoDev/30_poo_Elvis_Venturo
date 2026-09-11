package vallegrande.edu.pe.miperfil.model;

public class perfil {
    private String nombre;
    private String carrera;
    private String semestre;
    private String juegoFavorito;

    public perfil(String nombre, String carrera, String semestre, String juegoFavorito) {
        this.nombre = nombre;
        this.carrera = carrera;
        this.semestre = semestre;
        this.juegoFavorito = juegoFavorito;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCarrera() {
        return carrera;
    }

    public String getSemestre() {
        return semestre;
    }

    public String getJuegoFavorito() {
        return juegoFavorito;
    }

    public String obtenerPresentacion80() {
        return "Hola, soy " + nombre + "\n" +
                "Carrera: " + carrera + "\n" +
                "Semestre: " + semestre + "\n" +
                "Juego Favorito: " + juegoFavorito;
    }
}