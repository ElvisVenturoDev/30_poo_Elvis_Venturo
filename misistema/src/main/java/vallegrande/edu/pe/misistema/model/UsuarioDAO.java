package vallegrande.edu.pe.misistema.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    public List<Usuario> listar() {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT id, nombre, apellido, correo, estado FROM usuarios";

        try (Connection cn = Conexion.conectar();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Usuario u = new Usuario(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("correo"),
                        rs.getString("estado")
                );
                lista.add(u);
            }
        } catch (SQLException e) {
            System.err.println("❌ ERROR AL LISTAR USUARIOS:");
            e.printStackTrace();
        }
        return lista;
    }

    public boolean insertar(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nombre, apellido, correo, estado) VALUES (?, ?, ?, ?)";

        try (Connection cn = Conexion.conectar();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellido());
            ps.setString(3, usuario.getCorreo());
            ps.setString(4, usuario.getEstado());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("❌ ERROR AL REGISTRAR USUARIO:");
            e.printStackTrace();
            return false;
        }
    }
}