package Modelos;

import ConexionBD.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActivoDAO {

    Connection conn = Conexion.getConnection();
    PreparedStatement ps;
    ResultSet rs;
    int respuesta;

    // Buscar activo por id
    public Activo buscar(int idActivo) {
        String sql = "SELECT * FROM Activos WHERE id_activo=?";
        Activo activo = new Activo(0, "", "", 0, 0, 0.0);
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idActivo);
            rs = ps.executeQuery();
            if (rs.next()) {
                activo.setIdActivo(rs.getInt(1));
                activo.setNombreActivo(rs.getString(2));
                activo.setDescripcion(rs.getString(3));
                activo.setIdGestion(rs.getInt(4));
                activo.setCantidad(rs.getInt(5));
                activo.setValorUnitario(rs.getDouble(6));
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar Activo: " + e.getMessage());
        }
        return activo;
    }

    // Listar todos los activos
    public List<Activo> listar() {
        String sql = "SELECT * FROM Activos";
        List<Activo> listaActivos = new ArrayList<>();
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Activo activo = new Activo(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getDouble(6)
                );
                listaActivos.add(activo);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar Activos: " + e.getMessage());
        }
        return listaActivos;
    }

    // Agregar nuevo activo
    public int agregar(Activo activo) {
        String sql = "INSERT INTO Activos (nombre_activo, descripcion, id_gestion, cantidad, valor_unitario) VALUES (?, ?, ?, ?, ?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, activo.getNombreActivo());
            ps.setString(2, activo.getDescripcion());
            ps.setInt(3, activo.getIdGestion());
            ps.setInt(4, activo.getCantidad());
            ps.setDouble(5, activo.getValorUnitario());
            respuesta = ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al insertar Activo: " + e.getMessage());
        }
        return respuesta;
    }

    // Actualizar activo
    public int actualizar(Activo activo) {
        String sql = "UPDATE Activos SET nombre_activo=?, descripcion=?, id_gestion=?, cantidad=?, valor_unitario=? WHERE id_activo=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, activo.getNombreActivo());
            ps.setString(2, activo.getDescripcion());
            ps.setInt(3, activo.getIdGestion());
            ps.setInt(4, activo.getCantidad());
            ps.setDouble(5, activo.getValorUnitario());
            ps.setInt(6, activo.getIdActivo());
            respuesta = ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al actualizar Activo: " + e.getMessage());
        }
        return respuesta;
    }

    // Eliminar activo
    public void eliminar(int idActivo) {
        String sql = "DELETE FROM Activos WHERE id_activo=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idActivo);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al eliminar Activo: " + e.getMessage());
        }
    }
}
