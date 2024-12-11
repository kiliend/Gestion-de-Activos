package Modelos;

import ConexionBD.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    Connection conn = Conexion.getConnection();
    PreparedStatement ps;
    ResultSet rs;
    int respuesta;

    // Buscar por id_usuario
    public Usuario buscar(int idUsuario) {
        String sql = "SELECT * FROM Usuarios WHERE id_usuario=?";
        Usuario usuario = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idUsuario);
            rs = ps.executeQuery();
            if (rs.next()) {
                usuario = new Usuario(
                    rs.getInt("id_usuario"),
                    rs.getString("nombre"),
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getString("rol"),
                    rs.getString("estado")
                );
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar Usuario: " + e.getMessage());
        } finally {
            closeResources();
        }
        return usuario;
    }

    // Listar todos los usuarios
    public List<Usuario> listar() {
        String sql = "SELECT * FROM Usuarios";
        List<Usuario> listaUsuarios = new ArrayList<>();
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario(
                    rs.getInt("id_usuario"),
                    rs.getString("nombre"),
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getString("rol"),
                    rs.getString("estado")
                );
                listaUsuarios.add(usuario);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar Usuarios: " + e.getMessage());
        } finally {
            closeResources();
        }
        return listaUsuarios;
    }

    // Agregar nuevo usuario
    public int agregar(Usuario usuario) {
        String sql = "INSERT INTO Usuarios (nombre, email, password, rol, estado) VALUES (?, ?, ?, ?, ?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getEmail());
            ps.setString(3, usuario.getContrasena());
            ps.setString(4, usuario.getRol());
            ps.setString(5, usuario.getEstado());
            respuesta = ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al insertar Usuario: " + e.getMessage());
        } finally {
            closeResources();
        }
        return respuesta;
    }

    // Actualizar usuario
    public int actualizar(Usuario usuario) {
        String sql = "UPDATE Usuarios SET nombre=?, email=?, password=?, rol=?, estado=? WHERE id_usuario=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getEmail());
            ps.setString(3, usuario.getContrasena());
            ps.setString(4, usuario.getRol());
            ps.setString(5, usuario.getEstado());
            ps.setInt(6, usuario.getIdUsuario());
            respuesta = ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al actualizar Usuario: " + e.getMessage());
        } finally {
            closeResources();
        }
        return respuesta;
    }

    // Eliminar usuario
    public void eliminar(int idUsuario) {
        String sql = "DELETE FROM Usuarios WHERE id_usuario=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idUsuario);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al eliminar Usuario: " + e.getMessage());
        } finally {
            closeResources();
        }
    }

    // Cerrar recursos
    private void closeResources() {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
        } catch (SQLException e) {
            System.err.println("Error al cerrar recursos: " + e.getMessage());
        }
    }

    // Validar usuario (Login)
    public Usuario validarUsuario(String email, String password) {
        String sql = "SELECT * FROM Usuarios WHERE email = ? AND password = ?";
        Usuario usuario = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);  // Recuerda que las contraseñas en producción deben estar encriptadas
            rs = ps.executeQuery();
            if (rs.next()) {
                usuario = new Usuario(
                    rs.getInt("id_usuario"),
                    rs.getString("nombre"),
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getString("rol"),
                    rs.getString("estado")
                );
            }
        } catch (SQLException e) {
            System.err.println("Error en validación de Usuario: " + e.getMessage());
        } finally {
            closeResources();
        }
        return usuario;
    }
public List<Cliente> buscarPorNombre(String nombre) {
    String sql = "SELECT * FROM Clientes WHERE razon_social LIKE ?";
    List<Cliente> listaClientes = new ArrayList<>();
    try {
        ps = conn.prepareStatement(sql);
        ps.setString(1, "%" + nombre + "%");  // LIKE para búsqueda parcial
        rs = ps.executeQuery();
        while (rs.next()) {
            // Asegúrate de que estos índices coincidan con el orden de las columnas en tu base de datos
            Cliente cliente = new Cliente(
                    rs.getInt("id_cliente"),       // Asegúrate de que este campo exista en la tabla de la BD
                    rs.getString("razon_social"),  // Asegúrate de que este campo exista en la tabla de la BD
                    rs.getString("contacto"),      // Asegúrate de que este campo exista en la tabla de la BD
                    rs.getString("telefono"),      // Asegúrate de que este campo exista en la tabla de la BD
                    rs.getString("email"),         // Asegúrate de que este campo exista en la tabla de la BD
                    rs.getString("direccion")      // Asegúrate de que este campo exista en la tabla de la BD
            );
            listaClientes.add(cliente);
        }
    } catch (SQLException e) {
        System.err.println("Error al buscar clientes por nombre: " + e.getMessage());
    }
    return listaClientes;
}

}
