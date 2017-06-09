    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.servlet;

import com.test.dto.VendedorDTO;
import com.test.negocio.VendedorNG;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author CAMILO SALAS
 */
public class Action extends HttpServlet {

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
       
       String USUARIO = request.getParameter("USUARIO");
       USUARIO = request.getParameter("USUARIO")==null?"":USUARIO; 
       String CLAVE = request.getParameter("CLAVE");
       CLAVE = request.getParameter("CLAVE")==null?"":CLAVE;
       
        
        VendedorNG vng = new VendedorNG();
        VendedorDTO vdto = vng.validarVendedor(USUARIO, CLAVE);
        
        
        if (vdto != null) {
            System.out.println("servlet!");
            //Trabajando con Sesiones
            HttpSession session = request.getSession();
            session.setAttribute("usuarioSesion", USUARIO);
            session.setAttribute("rol", vdto.getROL());
            //System.out.println("ROL: "+udto.getRol());
            
            
            switch(vdto.getROL()){
                case "admin":
                    
                    request.setAttribute("listaVendedor", vng.ListarVendedor()); 
                    request.setAttribute("USUARIO", USUARIO);       
                    request.getRequestDispatcher("PagAdmi.jsp").forward(request, response);
                    break;
                case "ventas":
                    request.getRequestDispatcher("vendedor.jsp").forward(request, response);
                    break;
            }
            
            

            
        } else {
            response.sendRedirect("loginBrisis.html");
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
