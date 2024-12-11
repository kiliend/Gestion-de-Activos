/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servelets;

import Modelos.Cliente;
import Modelos.Usuario;
import Modelos.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author Luan Condori
 */
@WebServlet(name = "UsuarioServlet", urlPatterns = {"/UsuarioServlet"})
public class UsuarioServlet extends HttpServlet {

    private UsuarioDAO usuarioDAO;
    public UsuarioServlet() {
        super();
        usuarioDAO = new UsuarioDAO();
    }
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UsuarioServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UsuarioServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

           String accion = request.getParameter("accion");
        
        if ("eliminar".equals(accion)) {
            int idUsuario = Integer.parseInt(request.getParameter("id"));
            usuarioDAO.eliminar(idUsuario); // Eliminar el usuario
            response.sendRedirect("UsuActualizar.jsp");  // Redirigir a la página de actualización
        } else if ("buscar".equals(accion)) {
            String nombreBuscar = request.getParameter("nombre");
            if (nombreBuscar != null && !nombreBuscar.isEmpty()) {
                // Buscar usuarios por nombre
                List<Cliente> usuarios = usuarioDAO.buscarPorNombre(nombreBuscar);
                request.setAttribute("usuarios", usuarios);
            }
            // Mostrar la página con los resultados de la búsqueda
            request.getRequestDispatcher("UsuActualizar.jsp").forward(request, response);
        } else {
            // Si no hay acción específica, listar todos los usuarios
            List<Usuario> usuarios = usuarioDAO.listar();
            request.setAttribute("usuarios", usuarios);
            request.getRequestDispatcher("UsuActualizar.jsp").forward(request, response);
        } }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      // Obtener los parámetros del formulario
        String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");
        String contrasena = request.getParameter("contrasena");
        String rol = request.getParameter("rol");
        String estado = request.getParameter("estado");

        // Crear un objeto Usuario con los datos obtenidos
        Usuario usuario = new Usuario(0, nombre, email, contrasena, rol, estado);

        // Crear una instancia de UsuarioDAO para insertar el usuario en la base de datos
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        int resultado = usuarioDAO.agregar(usuario);

        // Comprobar el resultado y redirigir a la página correspondiente
        if (resultado > 0) {
            // Si el usuario se registró correctamente, redirigir a la lista de usuarios
            response.sendRedirect("UsuRegistrar.jsp");
        } else {
            // Si hubo un error al registrar el usuario, redirigir de nuevo al formulario
            response.sendRedirect("UsuRegistrar.jsp");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
