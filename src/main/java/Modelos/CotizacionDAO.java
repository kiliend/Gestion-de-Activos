package Modelos;


import ConexionBD.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CotizacionDAO {

    Connection conn = Conexion.getConnection();
    PreparedStatement ps;
    ResultSet rs;
    int respuesta;

    // Buscar cotización por id
    public Cotizacion buscar(int idCotizacion) {
        String sql = "SELECT * FROM Cotizaciones WHERE id_cotizacion=?";
        Cotizacion cotizacion = new Cotizacion(0, 0, 0, null, 0.0, "", "pendiente");
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idCotizacion);
            rs = ps.executeQuery();
            if (rs.next()) {
                cotizacion.setIdCotizacion(rs.getInt(1));
                cotizacion.setIdCliente(rs.getInt(2));
                cotizacion.setIdUsuario(rs.getInt(3));
                cotizacion.setFecha(rs.getDate(4));
                cotizacion.setTotal(rs.getDouble(5));
                cotizacion.setDescripcion(rs.getString(6));
                cotizacion.setEstado(rs.getString(7));
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar Cotización: " + e.getMessage());
        }
        return cotizacion;
    }

    // Listar todas las cotizaciones
    public List<Cotizacion> listar() {
        String sql = "SELECT * FROM Cotizaciones";
        List<Cotizacion> listaCotizaciones = new ArrayList<>();
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cotizacion cotizacion = new Cotizacion(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getDate(4),
                        rs.getDouble(5),
                        rs.getString(6),
                        rs.getString(7)
                );
                listaCotizaciones.add(cotizacion);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar Cotizaciones: " + e.getMessage());
        }
        return listaCotizaciones;
    }

    // Agregar nueva cotización
    public int agregar(Cotizacion cotizacion) {
        String sql = "INSERT INTO Cotizaciones (id_cliente, id_usuario, fecha, total, descripcion, estado) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, cotizacion.getIdCliente());
            ps.setInt(2, cotizacion.getIdUsuario());
            ps.setDate(3, new java.sql.Date(cotizacion.getFecha().getTime()));
            ps.setDouble(4, cotizacion.getTotal());
            ps.setString(5, cotizacion.getDescripcion());
            ps.setString(6, cotizacion.getEstado());
            respuesta = ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al insertar Cotización: " + e.getMessage());
        }
        return respuesta;
    }

    // Actualizar cotización
    public int actualizar(Cotizacion cotizacion) {
        String sql = "UPDATE Cotizaciones SET id_cliente=?, id_usuario=?, fecha=?, total=?, descripcion=?, estado=? WHERE id_cotizacion=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, cotizacion.getIdCliente());
            ps.setInt(2, cotizacion.getIdUsuario());
           ps.setDate(3, new java.sql.Date(cotizacion.getFecha().getTime()));
            ps.setDouble(4, cotizacion.getTotal());
            ps.setString(5, cotizacion.getDescripcion());
            ps.setString(6, cotizacion.getEstado());
            ps.setInt(7, cotizacion.getIdCotizacion());
            respuesta = ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al actualizar Cotización: " + e.getMessage());
        }
        return respuesta;
    }

    // Eliminar cotización
    public void eliminar(int idCotizacion) {
        String sql = "DELETE FROM Cotizaciones WHERE id_cotizacion=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idCotizacion);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al eliminar Cotización: " + e.getMessage());
        }
    }
}
