package Modelos;

import ConexionBD.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FacturaDAO {

    Connection conn = Conexion.getConnection();
    PreparedStatement ps;
    ResultSet rs;
    int respuesta;

    // Buscar factura por id
    public Factura buscar(int idFactura) {
        String sql = "SELECT * FROM Facturas WHERE id_factura=?";
        Factura factura = new Factura(0, 0, 0, null, 0.0, "", "emitida");
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idFactura);
            rs = ps.executeQuery();
            if (rs.next()) {
                factura.setIdFactura(rs.getInt(1));
                factura.setIdCliente(rs.getInt(2));
                factura.setIdUsuario(rs.getInt(3));
                factura.setFecha(rs.getDate(4));
                factura.setTotal(rs.getDouble(5));
                factura.setDescripcion(rs.getString(6));
                factura.setEstado(rs.getString(7));
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar Factura: " + e.getMessage());
        }
        return factura;
    }

    // Listar todas las facturas
    public List<Factura> listar() {
        String sql = "SELECT * FROM Facturas";
        List<Factura> listaFacturas = new ArrayList<>();
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Factura factura = new Factura(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getDate(4),
                        rs.getDouble(5),
                        rs.getString(6),
                        rs.getString(7)
                );
                listaFacturas.add(factura);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar Facturas: " + e.getMessage());
        }
        return listaFacturas;
    }

    // Agregar nueva factura
    public int agregar(Factura factura) {
        String sql = "INSERT INTO Facturas (id_cliente, id_usuario, fecha, total, descripcion, estado) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, factura.getIdCliente());
            ps.setInt(2, factura.getIdUsuario());
            ps.setDate(3, new java.sql.Date(factura.getFecha().getTime()));
            ps.setDouble(4, factura.getTotal());
            ps.setString(5, factura.getDescripcion());
            ps.setString(6, factura.getEstado());
            respuesta = ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al insertar Factura: " + e.getMessage());
        }
        return respuesta;
    }

    // Actualizar factura
    public int actualizar(Factura factura) {
        String sql = "UPDATE Facturas SET id_cliente=?, id_usuario=?, fecha=?, total=?, descripcion=?, estado=? WHERE id_factura=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, factura.getIdCliente());
            ps.setInt(2, factura.getIdUsuario());
            ps.setDate(3, new java.sql.Date(factura.getFecha().getTime()));
            ps.setDouble(4, factura.getTotal());
            ps.setString(5, factura.getDescripcion());
            ps.setString(6, factura.getEstado());
            ps.setInt(7, factura.getIdFactura());
            respuesta = ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al actualizar Factura: " + e.getMessage());
        }
        return respuesta;
    }

    // Eliminar factura
    public void eliminar(int idFactura) {
        String sql = "DELETE FROM Facturas WHERE id_factura=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idFactura);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al eliminar Factura: " + e.getMessage());
        }
    }
}
