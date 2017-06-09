/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.negocio;

import com.test.conexion.conMySQL;
import com.test.dto.ProductoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CAMILO SALAS
 */
public class ProductoNG {
    
     private Connection conn;
     
     public List<ProductoDTO> listarProducto(){
        List<ProductoDTO> lista = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        
        String query = "select Idproducto, nombre, precio, costo, unid_medida, codigo, estado, stock from producto";
        ProductoDTO pdto = null;
        try {
            lista = new ArrayList<>();
            conn = conMySQL.getConexion();
            st = conn.prepareStatement(query);
            rs = st.executeQuery();
            
            while (rs.next()) {
                
                pdto = new ProductoDTO();
                pdto.setIdproducto(rs.getInt("Idproducto"));
                pdto.setNombre(rs.getString("Nombre"));
                pdto.setPrecio(rs.getString("Precio"));
                pdto.setCosto(rs.getString("Costo"));
                pdto.setUnid_medida(rs.getString("Unid_medida"));
                pdto.setCodigo(rs.getString("Codigo"));
                pdto.setEstado(rs.getString("Estado"));
                pdto.setStock(rs.getString("Stock"));
                
                
                lista.add(pdto);
            }
            
            conn.close();
            
        } catch (Exception e) {
            try {
                conn.close();
                System.out.println("ERROR Listar Producto: "+e.getMessage());
            } catch (Exception ex) {
                
            }  
        }
        return lista;
    }
    
    public boolean agregarProducto(ProductoDTO pdto){
        boolean flat = false;
        PreparedStatement st = null;
        String query = "insert into producto (Idproducto,nombre,precio,costo,unid_medida,codigo,estado,stock)values(?,?,?,?,?,?,?,?)";
        try {
            conn = conMySQL.getConexion();
            st = conn.prepareStatement(query);
            st.setInt(1, pdto.getIdproducto());
            st.setString(2, pdto.getNombre());
            st.setString(3, pdto.getPrecio());
            st.setString(4, pdto.getCosto());
            st.setString(5, pdto.getUnid_medida());
            st.setString(6, pdto.getCodigo());
            st.setString(7, pdto.getEstado());
            st.setString(8, pdto.getStock());
            st.executeUpdate();
            //conn.commit();
            conn.close();
            flat = true;
            
        } catch (Exception e) {
            try {
                flat = false;
                conn.rollback();
                conn.close();
                System.out.println("ERROR agregar Producto: "+e.getMessage());
            } catch (SQLException ex) {                
            }
        }
        
        return flat; 
    }
    
    public boolean actualizarProducto(ProductoDTO pdto){
        boolean flat = false;
        PreparedStatement st = null;
        String query = "update producto set nombre = ?, precio = ?, costo = ?, unid_medida = ?, codigo = ?, estado = ?, stock = ? where Idproducto = ?";
        try {
            conn = conMySQL.getConexion();
            st = conn.prepareStatement(query);
            st.setString(1, pdto.getNombre());
            st.setString(2, pdto.getPrecio());
            st.setString(3, pdto.getCosto());
            st.setString(4, pdto.getUnid_medida());
            st.setString(5, pdto.getCodigo());
            st.setString(6, pdto.getEstado());
            st.setString(7, pdto.getStock());
            st.setInt(8, pdto.getIdproducto());
            st.executeUpdate();
            //cn.commit();
            conn.close();
            flat = true;
        } catch (Exception e) {
            try {
                flat = false;
                conn.rollback();
                conn.close();
                System.out.println("ERROR Actualizar Producto: "+e.getMessage());
            } catch (SQLException ex) {                
            }
            
        }
        return flat;
    }
    
    public ProductoDTO buscarProductoId(int ID){
        PreparedStatement st = null;
        ResultSet rs = null;
        String query = "select Idproducto, nombre, precio, costo, unid_medida, codigo, estado, stock from producto where Idproducto = ?";
        ProductoDTO pdto = null;
        try {
            conn = conMySQL.getConexion();
            st = conn.prepareStatement(query);
            st.setInt(1, ID);
            rs = st.executeQuery();
            if (rs.next()) {
                pdto = new ProductoDTO();
                pdto.setIdproducto(rs.getInt("IdProducto"));
                pdto.setNombre(rs.getString("Nombre"));
                pdto.setPrecio(rs.getString("Precio"));
                pdto.setCosto(rs.getString("Costo"));
                pdto.setUnid_medida(rs.getString("Unid_medida"));
                pdto.setCodigo(rs.getString("Codigo"));
                pdto.setEstado(rs.getString("Estado"));
                pdto.setStock(rs.getString("Stock"));
            }
            conn.close();
        } catch (Exception e) {
            try {
                conn.close();
                System.out.println("ERROR validar Producto: "+e.getMessage());
            } catch (SQLException ex) {                
            }
        }
                
        return pdto;
    }
    
    public boolean eliminarProducto(int ID){
        boolean flat = false;
        
        PreparedStatement st = null;
        String query = "delete from producto where Idproducto = ?";
        try {  
                     
            conn = conMySQL.getConexion();
            st = conn.prepareStatement(query);
            st.setInt(1, ID);            
            st.executeUpdate();
            //cn.commit();
            conn.close();
            flat = true;
        } catch (Exception e) {
            try {
                flat = false;
                conn.rollback();
                conn.close();
                System.out.println("ERROR eliminar Producto: "+e.getMessage());
            } catch (SQLException ex) {                
            }
            
        }
        
    return flat;    
    }
    
}
