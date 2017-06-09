/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.servlet;

import com.test.dto.ClienteDTO;
import com.test.negocio.ClientesNG;
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
public class Direccion extends HttpServlet {

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
        
        String Idclientes = request.getParameter("Idclientes");
        Idclientes = request.getParameter("Idclientes")== null?"0":Idclientes;
        
        String Nombres = request.getParameter("Nombres");
        Nombres = request.getParameter("Nombres")== null?"":Nombres;
        
        String Appaterno = request.getParameter("Appaterno");
        Appaterno = request.getParameter("Appaterno")== null?"":Appaterno;
        
        String Dni = request.getParameter("Dni");
        Dni = request.getParameter("Dni")== null?"":Dni;
        
        String op = request.getParameter("op");
        op = request.getParameter("op")== null?"":op;
        
        ClientesNG cg = new ClientesNG();
        ClienteDTO cdto = new ClienteDTO();
        
        switch(op){
            
            case "añadirCliente":
                
                cdto.setNombres(Nombres);
                cdto.setAppaterno(Appaterno);
                cdto.setDni(Dni);
                
                cg.agregarCliente(cdto);
                
                request.setAttribute("listaCliente", cg.listarCliente());
                request.getRequestDispatcher("cliente.jsp").forward(request, response);
                
            break;
                
            case "encontrarCliente":
                
                request.setAttribute("clientedto", cg.buscarClienteId(Integer.parseInt(Idclientes)));
                request.getRequestDispatcher("Actualizar/actualizarCliente.jsp").forward(request, response);
                
            break;
                
            case "actualizarCliente":
                
                cdto.setIdclientes(Integer.parseInt(Idclientes));
                cdto.setNombres(Nombres);
                cdto.setAppaterno(Appaterno);
                cdto.setDni(Dni);
                
                cg.actualizarCliente(cdto);
                
                request.setAttribute("listaCliente", cg.listarCliente());
                request.getRequestDispatcher("cliente.jsp").forward(request, response);
                
            break;
                
            case "listarCliente":
                
                cdto.setNombres(Nombres);
                cdto.setAppaterno(Appaterno);
                cdto.setDni(Dni);
                
                request.setAttribute("listaCliente", cg.listarCliente());
                request.getRequestDispatcher("cliente.jsp").forward(request, response);
            break;
                
            case "borrarCliente":
                
                cg.eliminarCliente(Integer.parseInt(Idclientes));
                request.setAttribute("listaCliente", cg.listarCliente());
                request.getRequestDispatcher("cliente.jsp").forward(request, response);
                
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
