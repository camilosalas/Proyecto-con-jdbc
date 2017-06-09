/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.servlet;

import com.test.dto.ProductoDTO;
import com.test.negocio.ProductoNG;
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
public class Rutaproducto extends HttpServlet {

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
        String Idproducto = request.getParameter("Idproducto");
        Idproducto = request.getParameter("Idproducto")== null?"0":Idproducto;
        
        String Nombre = request.getParameter("Nombre");
        Nombre = request.getParameter("Nombre")== null?"":Nombre;
        
        String Precio = request.getParameter("Precio");
        Precio = request.getParameter("Precio")== null?"":Precio;
        
        String Costo = request.getParameter("Costo");
        Costo = request.getParameter("Costo")== null?"":Costo;
        
        String Unid_medida = request.getParameter("Unid_medida");
        Unid_medida = request.getParameter("Unid_medida")== null?"":Unid_medida;
        
        String Codigo = request.getParameter("Codigo");
        Codigo = request.getParameter("Codigo")== null?"":Codigo;
        
        String Estado = request.getParameter("Estado");
        Estado = request.getParameter("Estado")== null?"":Estado;
        
        String Stock = request.getParameter("Stock");
        Stock = request.getParameter("Stock")== null?"":Stock;
        
        String op = request.getParameter("op");
        op = request.getParameter("op")== null?"":op;
        
        ProductoNG pg = new ProductoNG();
        ProductoDTO pdto = new ProductoDTO();
        
        switch(op){
            
            case "añadirProducto":
                
                pdto.setNombre(Nombre);
                pdto.setPrecio(Precio);
                pdto.setCosto(Costo);
                pdto.setUnid_medida(Unid_medida);
                pdto.setCodigo(Codigo);
                pdto.setEstado(Estado);
                pdto.setStock(Stock);
                
                pg.agregarProducto(pdto);
                
                request.setAttribute("listaProducto", pg.listarProducto());
                request.getRequestDispatcher("Producto.jsp").forward(request, response);
                
            break;
                
            case "encontrarProducto":
                
                request.setAttribute("productodto", pg.buscarProductoId(Integer.parseInt(Idproducto)));
                request.getRequestDispatcher("Actualizar/actualizarProducto.jsp").forward(request, response);
                
            break;
                
            case "actualizarPro":
                
                pdto.setIdproducto(Integer.parseInt(Idproducto));
                pdto.setNombre(Nombre);
                pdto.setPrecio(Precio);
                pdto.setCosto(Costo);
                pdto.setUnid_medida(Unid_medida);
                pdto.setCodigo(Codigo);
                pdto.setEstado(Estado);
                pdto.setStock(Stock);
                
                pg.actualizarProducto(pdto);
                
                request.setAttribute("listaProducto", pg.listarProducto());
                request.getRequestDispatcher("Producto.jsp").forward(request, response);
                
            break;
                
            case "lisProducto":
                
                pdto.setNombre(Nombre);
                pdto.setPrecio(Precio);
                pdto.setCosto(Costo);
                pdto.setUnid_medida(Unid_medida);
                pdto.setCodigo(Codigo);
                pdto.setEstado(Estado);
                pdto.setStock(Stock);
                
                
                request.setAttribute("listaProducto", pg.listarProducto());
                request.getRequestDispatcher("Producto.jsp").forward(request, response);
            break;
                
            case "borrarProducto":
                
                pg.eliminarProducto(Integer.parseInt(Idproducto));
                request.setAttribute("listaProducto", pg.listarProducto());
                request.getRequestDispatcher("Producto.jsp").forward(request, response);
                
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
