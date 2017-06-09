/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.servlet;

import com.test.dto.ProveedorDTO;
import com.test.negocio.ProveedorNG;
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
public class Rutaproveedor extends HttpServlet {

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
        
        String idproveedor = request.getParameter("idproveedor");
        idproveedor = request.getParameter("idproveedor")==null?"0":idproveedor;
        
        String nombre = request.getParameter("nombre");
        nombre = request.getParameter("nombre")==null?"":nombre;
        
        String apellido = request.getParameter("apellido");
        apellido = request.getParameter("apellido")==null?"":apellido;
        
        String dni = request.getParameter("dni");
        dni = request.getParameter("dni")==null?"":dni;
        
        String empresa = request.getParameter("empresa");
        empresa = request.getParameter("empresa")==null?"":empresa;
        
        String telefono = request.getParameter("telefono");
        telefono = request.getParameter("telefono")==null?"":telefono;
        
        String celular = request.getParameter("celular");
        celular = request.getParameter("celular")==null?"":celular;
        
        String correo = request.getParameter("correo");
        correo = request.getParameter("correo")==null?"":correo;
       
       String pro = request.getParameter("pro");
       pro = request.getParameter("pro")==null?"":pro;
       
        ProveedorNG prng = new ProveedorNG();
        ProveedorDTO prdto = new ProveedorDTO();
        
        switch(pro){
            
            case "añadirprove":
                
                prdto.setNombre(nombre);
                prdto.setApellido(apellido);
                prdto.setDni(dni);
                prdto.setEmpresa(empresa);
                prdto.setTelefono(telefono);
                prdto.setCelular(celular);
                prdto.setCorreo(correo);
                 
                prng.agregarProveedor(prdto);
                
                request.setAttribute("listaprove", prng.listarProveedor());
                request.getRequestDispatcher("Proveedores.jsp").forward(request, response);
                
                break;
                
            case "encontrarprove":
                
                request.setAttribute("proveedordto", prng.buscarProveedorId(Integer.parseInt(idproveedor)));
                request.getRequestDispatcher("Actualizar/actualizarProveedor.jsp").forward(request, response);
                             
               break; 
            
            case "actualizarprove": 
                
               prdto.setIdproveedor(Integer.parseInt(idproveedor));
               prdto.setNombre(nombre);
               prdto.setApellido(apellido);
               prdto.setDni(dni);
               prdto.setEmpresa(empresa);
               prdto.setTelefono(telefono);
               prdto.setCelular(celular);
               prdto.setCorreo(correo);
               
               prng.actualizarProveedor(prdto);
               
               request.setAttribute("listaprove", prng.listarProveedor());
               request.getRequestDispatcher("Proveedores.jsp").forward(request, response);
               
               break;     
            
            case "listarprove":
                
               prdto.setNombre(nombre);
               prdto.setApellido(apellido);
               prdto.setDni(dni);
               prdto.setEmpresa(empresa);
               prdto.setTelefono(telefono);
               prdto.setCelular(celular);
               prdto.setCorreo(correo);
                
               request.setAttribute("listaprove", prng.listarProveedor());
               request.getRequestDispatcher("Proveedores.jsp").forward(request, response);
               
               break; 
                
            case "borrarprove": 
                
                prng.eliminarProveedor(Integer.parseInt(idproveedor));
                request.setAttribute("listaprove", prng.listarProveedor());
                request.getRequestDispatcher("Proveedores.jsp").forward(request, response);
               
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
