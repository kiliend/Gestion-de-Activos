package Modelos;

import ConexionBD.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    Connection conn = Conexion.getConnection();
    PreparedStatement ps;
    ResultSet rs;
    int respuesta;

    // Buscar cliente por id_cliente
    public Cliente buscar(int idCliente) {
        String sql = "SELECT * FROM Clientes WHERE id_cliente=?";
        Cliente cliente = new Cliente(0, "", "", "", "", "");
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idCliente);
            rs = ps.executeQuery();
            if (rs.next()) {
                cliente.setIdCliente(rs.getInt(1));
                cliente.setRazonSocial(rs.getString(2));
                cliente.setContacto(rs.getString(3));
                cliente.setTelefono(rs.getString(4));
                cliente.setEmail(rs.getString(5));
                cliente.setDireccion(rs.getString(6));
            }
        } catch (SQLException e) {
            System.err.println("Error en buscar Cliente: " + e.getMessage());
        }
        return cliente;
    }

    // Listar todos los clientes
    public List<Cliente> listar() {
        String sql = "SELECT * FROM Clientes";
        List<Cliente> listaClientes = new ArrayList<>();
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)
                );
                listaClientes.add(cliente);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar Clientes: " + e.getMessage());
        }
        return listaClientes;
    }

    // Agregar nuevo cliente
    public int agregar(Cliente cliente) {
        String sql = "INSERT INTO Clientes (razon_social, contacto, telefono, email, direccion) VALUES (?, ?, ?, ?, ?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, cliente.getRazonSocial());
            ps.setString(2, cliente.getContacto());
            ps.setString(3, cliente.getTelefono());
            ps.setString(4, cliente.getEmail());
            ps.setString(5, cliente.getDireccion());
            respuesta = ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al insertar Cliente: " + e.getMessage());
        }
        return respuesta;
    }

    // Actualizar cliente
    public int actualizar(Cliente cliente) {
        String sql = "UPDATE Clientes SET razon_social=?, contacto=?, telefono=?, email=?, direccion=? WHERE id_cliente=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, cliente.getRazonSocial());
            ps.setString(2, cliente.getContacto());
            ps.setString(3, cliente.getTelefono());
            ps.setString(4, cliente.getEmail());
            ps.setString(5, cliente.getDireccion());
            ps.setInt(6, cliente.getIdCliente());
            respuesta = ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al actualizar Cliente: " + e.getMessage());
        }
        return respuesta;
    }

    // Eliminar cliente
    public void eliminar(int idCliente) {
        String sql = "DELETE FROM Clientes WHERE id_cliente=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idCliente);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al eliminar Cliente: " + e.getMessage());
        }
    }
}
