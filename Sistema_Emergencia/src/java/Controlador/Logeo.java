/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Persona;
import Modelo.PersonaDAO;
import ds.desktop.notify.DesktopNotify;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jose_
 */
public class Logeo extends HttpServlet {

    PersonaDAO persDao = new PersonaDAO();

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
        processRequest(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        String email = request.getParameter("txtuser");
        String password = request.getParameter("txtpass");
        if (email!=""&&password!="") {       
        Persona person = persDao.validar(email, password);
        if (person.getId_persona() != 0) {
            request.setAttribute("usuariolog", person);
            response.sendRedirect("Principal.jsp");
        } else {
            DesktopNotify.showDesktopMessage("Error de Inicio de Sesión", "Usuario y/o contraseña incorrecta",DesktopNotify.FAIL,2000);
            request.getRequestDispatcher("index.jsp").forward(request, response);
            
        }
        }else{
            DesktopNotify.showDesktopMessage("Error de Inicio de Sesión", "Rellene los campos",DesktopNotify.WARNING,2000);
            request.getRequestDispatcher("index.jsp").forward(request, response);
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
