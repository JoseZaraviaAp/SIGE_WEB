/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Ambulancia;
import Modelo.AmbulanciaDAO;
import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import Modelo.Paciente;
import Modelo.PacienteDAO;
import Modelo.Persona;
import Modelo.PersonaDAO;
import Modelo.Solicitud_Emergencia;
import Modelo.Solicitud_EmergenciaDAO;
import ds.desktop.notify.DesktopNotify;
import java.io.IOException;
import static java.lang.System.out;
import java.util.List;
import javafx.scene.control.Alert;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admi
 */
public class Controlador extends HttpServlet {

    Ambulancia am = new Ambulancia();
    AmbulanciaDAO adao = new AmbulanciaDAO();
    int ida;

    Empleado emp = new Empleado();
    EmpleadoDAO empdao = new EmpleadoDAO();
    int idemp;

    Persona per = new Persona();
    PersonaDAO pdao = new PersonaDAO();
    int idp;

    Solicitud_Emergencia se = new Solicitud_Emergencia();
    Solicitud_EmergenciaDAO sedao = new Solicitud_EmergenciaDAO();
    int ids;

    Paciente pa = new Paciente();
    PacienteDAO padao = new PacienteDAO();
    int idpac;

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
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        if (menu.equals("Principal")) {
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }
        if (menu.equals("Home")) {
            request.getRequestDispatcher("Dashboard.jsp").forward(request, response);
        }
        if (menu.equals("Ambulancia")) {
            switch (accion) {
                case "Listar":
                    List lista = adao.listar();
                    request.setAttribute("ambulanciasv", lista);
                    break;
                case "Agregar":
                    String placa = request.getParameter("placa");
                    String dispo = request.getParameter("disponibilidad");
                    if (placa!=""&&dispo!="") { 
                    am.setPlaca(placa);
                    am.setIddispo(dispo);
                    adao.agregar(am);
                    DesktopNotify.showDesktopMessage("Éxito!", "Se ha añadido al vehículo con la placa : "+placa,DesktopNotify.SUCCESS,2000);
                    }else{
                        DesktopNotify.showDesktopMessage("Error de registro!", "Verifique los campos vacíos ",DesktopNotify.WARNING,2000);
                    }
                    request.getRequestDispatcher("Controlador?menu=Ambulancia&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    ida = Integer.parseInt(request.getParameter("id"));
                    Ambulancia a = adao.listarId(ida);
                    request.setAttribute("ambulancias", a);
                    request.getRequestDispatcher("Controlador?menu=Ambulancia&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String placa1 = request.getParameter("placa");
                    String dispo1 = request.getParameter("disponibilidad");
                    if (placa1!=""&&dispo1!="") {                   
                    am.setPlaca(placa1);
                    am.setIddispo(dispo1);
                    am.setId(ida);
                    adao.actualizar(am);
                    DesktopNotify.showDesktopMessage("Éxito!", "Se han modificado los datos",DesktopNotify.INFORMATION,2000);
                    }else{
                        DesktopNotify.showDesktopMessage("Error de registro!", "Rellene los campos",DesktopNotify.WARNING,2000);
                    }
                    request.getRequestDispatcher("Controlador?menu=Ambulancia&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    ida = Integer.parseInt(request.getParameter("id"));
                    adao.delete(ida);
                    request.getRequestDispatcher("Controlador?menu=Ambulancia&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();

            }
            request.getRequestDispatcher("Ambulancia.jsp").forward(request, response);
        }
        if (menu.equals("Solicitud")) {
            switch (accion) {
                case "Listar":
                    List lista = sedao.listar();
                    request.setAttribute("solicitudes", lista);
                    break;
                case "Agregar":

                    request.getRequestDispatcher("Controlador?menu=Solicitud&accion=Listar").forward(request, response);
                    break;
                case "Editar":

                    request.getRequestDispatcher("Controlador?menu=Solicitud&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":

                    request.getRequestDispatcher("Controlador?menu=Solicitud&accion=Listar").forward(request, response);
                    break;
                case "Delete":

                    request.getRequestDispatcher("Controlador?menu=Solicitud&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();

            }
            request.getRequestDispatcher("Solicitud_Emergencia.jsp").forward(request, response);
        }
        if (menu.equals("Paciente")) {
            switch (accion) {
                case "Listar":
                    List lista = padao.listar();
                    request.setAttribute("pacientes", lista);
                    break;
                case "Delete":
                    padao.eliminar(2, idpac);
                    request.setAttribute("pacientes", padao.listar());
                    break;
                default:
                    throw new AssertionError();

            }
            request.getRequestDispatcher("Paciente.jsp").forward(request, response);
        }

        if (menu.equals("Persona")) {
            switch (accion) {
                case "Listar":
                    List lista = pdao.listar();
                    request.setAttribute("personasx", lista);
                    break;
                case "Agregar":
                    String dni = request.getParameter("dni");
                    String nom = request.getParameter("nombre");
                    String ape = request.getParameter("apellido");
                    String fec = request.getParameter("fecha");
                    String dir = request.getParameter("direccion");
                    String thu = request.getParameter("thumbnail");
                    String est = request.getParameter("estado");
                   
                    per.setDni(dni);
                    per.setNombre(nom);
                    per.setApellido(ape);
                    per.setFecha(fec);
                    per.setDireccion(dir);
                    per.setImg(thu);
                    per.setEstado(est);

                    request.getRequestDispatcher("Controlador?menu=Persona&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();

            }
            request.getRequestDispatcher("Persona.jsp").forward(request, response);
        }
        if (menu.equals("Empleados")) {
            switch (accion) {
                case "Listar":
                    List lista = empdao.listar();
                    request.setAttribute("empls", lista);
                    break;
                case "Agregar":
                    String DNI = request.getParameter("dni");
                    String nombre = request.getParameter("nombre");
                    String apellido = request.getParameter("apellido");
                    String fechanac = request.getParameter("fecha");
                    String direccion = request.getParameter("direccion");
                    String estadocivil = request.getParameter("estadocivil");
                    String cargo = request.getParameter("cargo");
                    String disponibilidad = request.getParameter("disponibilidad");
                    if (DNI!=""&&nombre!=""&&apellido!=""&&fechanac!=""
                            &&direccion!=""&&estadocivil!=""&&cargo!=""&&disponibilidad!="") 
                    {                      
                    emp.setDni(Integer.parseInt(DNI));
                    emp.setNombre(nombre);
                    emp.setApellido(apellido);
                    emp.setFechanac(fechanac);
                    emp.setDireccion(direccion);
                    emp.setEstadocivil(estadocivil);
                    emp.setCargo(cargo);
                    emp.setEstado(disponibilidad);
                    empdao.agregar(emp);
                    DesktopNotify.showDesktopMessage("Éxito!", "Se ha añadido al empleado "+nombre+" "+apellido,DesktopNotify.SUCCESS,2000);
                    }else{
                        DesktopNotify.showDesktopMessage("Error de registro!", "Rellene los campos",DesktopNotify.WARNING,2000);
                    }
                    request.setAttribute("empls", empdao.listar());
                    break;
                case "Editar":
                    idemp = Integer.parseInt(request.getParameter("id"));
                    Empleado empl = empdao.listarId(idemp);
                    request.setAttribute("empleads", empl);
                    List lista2 = empdao.listar();                    
                    request.setAttribute("empls", lista2);
                    //request.getRequestDispatcher("Controlador?menu=Empleados&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String DNI1 = request.getParameter("dni");
                    String nombre1 = request.getParameter("nombre");
                    String apellido1 = request.getParameter("apellido");
                    String fechanac1 = request.getParameter("fecha");
                    String direccion1 = request.getParameter("direccion");
                    String estadocivil1 = request.getParameter("estadocivil");
                    String cargo1 = request.getParameter("cargo");
                    String disponibilidad1 = request.getParameter("disponibilidad");
                    emp.setEmpleadoId(idemp);
                    emp.setDni(Integer.parseInt(DNI1));
                    emp.setNombre(nombre1);
                    emp.setApellido(apellido1);
                    emp.setFechanac(fechanac1);
                    emp.setDireccion(direccion1);
                    emp.setEstadocivil(estadocivil1);
                    emp.setCargo(cargo1);
                    emp.setEstado(disponibilidad1);
                    empdao.actualizar(emp);
                    DesktopNotify.showDesktopMessage("Éxito!", "Se han modificado los datos",DesktopNotify.INFORMATION,2000);
                    request.setAttribute("empls", empdao.listar());
                    break;
                case "Delete":
                    idemp = Integer.parseInt(request.getParameter("id"));
                    empdao.eliminar(2, idemp);

                    request.getRequestDispatcher("Controlador?menu=Empleados&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Empleado.jsp").forward(request, response);
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
        processRequest(request, response);
    }

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
        processRequest(request, response);
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
