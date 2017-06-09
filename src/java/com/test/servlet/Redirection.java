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

/**
 *
 * @author CAMILO SALAS
 */
public class Redirection extends HttpServlet {

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
       
       String ROL = request.getParameter("ROL");
       ROL = request.getParameter("ROL")==null?"":ROL;
       
       String ID_VENDEDOR = request.getParameter("ID_VENDEDOR");
        //String idusuario = null;
       ID_VENDEDOR = request.getParameter("ID_VENDEDOR")==null?"0":ID_VENDEDOR;
       
       String op = request.getParameter("op");
       op = request.getParameter("op")==null?"":op;
       
       
       VendedorNG vg = new VendedorNG();
       VendedorDTO vdto = new VendedorDTO();
       
       switch(op){
           
              case "añadir":
               vdto.setUSUARIO(USUARIO);
               vdto.setCLAVE(CLAVE);
               vdto.setROL(ROL);
               vg.agregarVendedor(vdto);
               
               request.setAttribute("listaVen", vg.ListarVendedor());
               request.getRequestDispatcher("usuarios.jsp").forward(request, response);
               
               break;  
               
            case "encontrar": 
               
               request.setAttribute("vendedordto", vg.buscarVendedorId(Integer.parseInt(ID_VENDEDOR)));
               request.getRequestDispatcher("Actualizar/actualizarVendedor.jsp").forward(request, response);
                             
               break;   
               
            case "actualizar": 
               vdto.setID_VENDEDOR(Integer.parseInt(ID_VENDEDOR));
               vdto.setUSUARIO(USUARIO);
               vdto.setCLAVE(CLAVE);
               vdto.setROL(ROL);
               
               vg.actualizarVendedor(vdto);
               request.setAttribute("listaVen", vg.ListarVendedor());
               request.getRequestDispatcher("usuarios.jsp").forward(request, response);
               
               break;     

                
            case "vendedor":
               
               vdto.setUSUARIO(USUARIO);
               vdto.setCLAVE(CLAVE);
               vdto.setROL(ROL);
               
               
               request.setAttribute("listaVen", vg.ListarVendedor());
               request.getRequestDispatcher("usuarios.jsp").forward(request, response);
               
               break;       
               
               
            case "borrar": 
               
               vg.eliminarVendedor(Integer.parseInt(ID_VENDEDOR));
               request.setAttribute("listaVen", vg.ListarVendedor());
               request.getRequestDispatcher("usuarios.jsp").forward(request, response);
               
               
               break;      
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
