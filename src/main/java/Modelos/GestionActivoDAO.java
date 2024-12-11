package Modelos;


import ConexionBD.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GestionActivoDAO {

    Connection conn = Conexion.getConnection();
    PreparedStatement ps;
    ResultSet rs;
    int respuesta;

    // Buscar gestion activo por id
    public GestionActivo buscar(int idGestion) {
        String sql = "SELECT * FROM GestionActivos WHERE id_gestion=?";
        GestionActivo gestionActivo = new GestionActivo(0, 0, 0, 0, 0, null, "pendiente");
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idGestion);
            rs = ps.executeQuery();
            if (rs.next()) {
                gestionActivo.setIdGestion(rs.getInt(1));
                gestionActivo.setIdCliente(rs.getInt(2));
                gestionActivo.setIdEncargado(rs.getInt(3));
                gestionActivo.setIdOperarios(rs.getInt(4));
                gestionActivo.setIdFactura(rs.getInt(5));
                gestionActivo.setFecha(rs.getDate(6));
                gestionActivo.setSituacion(rs.getString(7));
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar Gestión de Activo: " + e.getMessage());
        }
        return gestionActivo;
    }

    // Listar todas las gestiones de activos
    public List<GestionActivo> listar() {
        String sql = "SELECT * FROM GestionActivos";
        List<GestionActivo> listaGestiones = new ArrayList<>();
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                GestionActivo gestionActivo = new GestionActivo(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getDate(6),
                        rs.getString(7)
                );
                listaGestiones.add(gestionActivo);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar Gestión de Activos: " + e.getMessage());
        }
        return listaGestiones;
    }

    // Agregar nueva gestion activo
    public int agregar(GestionActivo gestionActivo) {
        String sql = "INSERT INTO GestionActivos (id_cliente, id_encargado, id_operarios, id_factura, fecha, situacion) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, gestionActivo.getIdCliente());
            ps.setInt(2, gestionActivo.getIdEncargado());
            ps.setInt(3, gestionActivo.getIdOperarios());
            ps.setInt(4, gestionActivo.getIdFactura());
            ps.setDate(5, (Date) gestionActivo.getFecha());
            ps.setString(6, gestionActivo.getSituacion());
            respuesta = ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al insertar Gestión de Activo: " + e.getMessage());
        }
        return respuesta;
    }

    // Actualizar gestion activo
    public int actualizar(GestionActivo gestionActivo) {
        String sql = "UPDATE GestionActivos SET id_cliente=?, id_encargado=?, id_operarios=?, id_factura=?, fecha=?, situacion=? WHERE id_gestion=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, gestionActivo.getIdCliente());
            ps.setInt(2, gestionActivo.getIdEncargado());
            ps.setInt(3, gestionActivo.getIdOperarios());
            ps.setInt(4, gestionActivo.getIdFactura());
            ps.setDate(5, (Date) gestionActivo.getFecha());
            ps.setString(6, gestionActivo.getSituacion());
            ps.setInt(7, gestionActivo.getIdGestion());
            respuesta = ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al actualizar Gestión de Activo: " + e.getMessage());
        }
        return respuesta;
    }

    // Eliminar gestion activo
    public void eliminar(int idGestion) {
        String sql = "DELETE FROM GestionActivos WHERE id_gestion=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idGestion);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al eliminar Gestión de Activo: " + e.getMessage());
        }
    }
}
