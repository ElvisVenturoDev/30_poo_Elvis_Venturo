package vallegrande.edu.pe.misistema.model;

public class Usuario {
    private int id;
    private String nombre;
    private String apellido;
    private String correo;
    private String estado;

    public Usuario() {}

    // Constructor con ID (para listar desde BD)
    public Usuario(int id, String nombre, String apellido, String correo, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.estado = estado;
    }

    // Constructor sin ID (para crear un nuevo registro)
    public Usuario(String nombre, String apellido, String correo, String estado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.estado = estado;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getCorreo() { return correo; }
    public String getEstado() { return estado; }
}