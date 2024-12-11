/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class Conexion {

    private static Connection conn = null;

    // Constructor privado para evitar que se cree una nueva instancia
    private Conexion() {
        String url = "jdbc:mysql://localhost:3306/GestionActivos";  // URL de tu base de datos
        String driver = "com.mysql.cj.jdbc.Driver";  // Driver de MySQL moderno
        String user = "root";  // Usuario de la base de datos
        String pass = "root";  // Contraseña del usuario (ajusta si es necesario)

        try {
            Class.forName(driver);  // Cargar el driver de MySQL
            conn = DriverManager.getConnection(url, user, pass);  // Establecer la conexión
            System.out.println("Conexión exitosa a la base de datos 'GestionActivos'.");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
        }
    }

    // Método público para obtener la conexión (singleton)
    public static Connection getConnection() {
        if (conn == null) {
            new Conexion();  // Si no hay conexión, la crea
        }
        return conn;
    }
}
