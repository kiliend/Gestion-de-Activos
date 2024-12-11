package Modelos;

import ConexionBD.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GestionActivosDAO {

    Connection conn = Conexion.getConnection();
    PreparedStatement ps;
    ResultSet rs;

    // Listar activos de un cliente
    public List<GestionActivos> listarActivos(int idCliente) {
        String sql = "SELECT * FROM GestionActivos WHERE id_cliente=?";
        List<GestionActivos> listaActivos = new ArrayList<>();
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idCliente);
            rs = ps.executeQuery();
            while (rs.next()) {
                GestionActivos gestion = new GestionActivos(
                        rs.getInt("id_gestion"),
                        rs.getInt("id_cliente"),
                        rs.getInt("id_encargado"),
                        rs.getInt("id_operarios"),
                        rs.getInt("id_factura"),
                        rs.getDate("fecha"),
                        rs.getString("situacion")
                );
                listaActivos.add(gestion);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar activos: " + e.getMessage());
        }
        return listaActivos;
    }

    // Agregar un nuevo registro de gestión de activos
    public int agregar(GestionActivos gestion) {
        String sql = "INSERT INTO GestionActivos (id_cliente, id_encargado, id_operarios, id_factura, fecha, situacion) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, gestion.getIdCliente());
            ps.setInt(2, gestion.getIdEncargado());
            ps.setInt(3, gestion.getIdOperarios());
            ps.setInt(4, gestion.getIdFactura());
            ps.setDate(5, new java.sql.Date(gestion.getFecha().getTime()));
            ps.setString(6, gestion.getSituacion());
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al agregar gestion de activos: " + e.getMessage());
        }
        return 0;
    }

    // Actualizar registro de gestión de activos
    public int actualizar(GestionActivos gestion) {
        String sql = "UPDATE GestionActivos SET id_cliente=?, id_encargado=?, id_operarios=?, id_factura=?, fecha=?, situacion=? WHERE id_gestion=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, gestion.getIdCliente());
            ps.setInt(2, gestion.getIdEncargado());
            ps.setInt(3, gestion.getIdOperarios());
            ps.setInt(4, gestion.getIdFactura());
            ps.setDate(5, new java.sql.Date(gestion.getFecha().getTime()));
            ps.setString(6, gestion.getSituacion());
            ps.setInt(7, gestion.getIdGestion());
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al actualizar gestion de activos: " + e.getMessage());
        }
        return 0;
    }

    // Eliminar registro de gestión de activos
    public void eliminar(int idGestion) {
        String sql = "DELETE FROM GestionActivos WHERE id_gestion=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idGestion);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al eliminar gestion de activos: " + e.getMessage());
        }
    }
}
