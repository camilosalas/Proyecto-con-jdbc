/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.negocio;

import com.test.conexion.conMySQL;
import com.test.dto.VendedorDTO;
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
public class VendedorNG {
    
    private Connection conn;
    
    public VendedorDTO validarVendedor(String usuario, String clave){
        PreparedStatement st = null;
        ResultSet rs = null;
        String query = "SELECT ID_VENDEDOR, USUARIO, ROL FROM VENDEDOR WHERE USUARIO = ? AND CLAVE = ?";
        VendedorDTO vdto = null;
        try {            
            conn = conMySQL.getConexion();
            st = conn.prepareStatement(query);
            st.setString(1, usuario);
            st.setString(2, clave);
            rs = st.executeQuery();
            if (rs.next()) {
                vdto = new VendedorDTO();
                vdto.setID_VENDEDOR(rs.getInt("ID_VENDEDOR"));
                vdto.setUSUARIO(rs.getString("USUARIO"));
                vdto.setROL(rs.getString("ROL"));                
            }
            conn.close();
        } catch (Exception e) {
            try {
                conn.close();
                System.out.println("ERROR validar Vendedor: "+e.getMessage());
            } catch (SQLException ex) {                
            }
        }
        return vdto;
    }
    
    
    public List<VendedorDTO> ListarVendedor(){
        
        List<VendedorDTO> lista =null;
        
        PreparedStatement st = null;
        ResultSet rs = null;
        String query = "SELECT ID_VENDEDOR, USUARIO, ROL FROM VENDEDOR";
        VendedorDTO vdto = null;
        try {  
            lista = new ArrayList<>();
            
            conn = conMySQL.getConexion();
            st = conn.prepareStatement(query);
            rs = st.executeQuery();
            while (rs.next()) {
                vdto = new VendedorDTO();
                vdto.setID_VENDEDOR(rs.getInt("ID_VENDEDOR"));
                vdto.setUSUARIO(rs.getString("USUARIO"));
                vdto.setROL(rs.getString("ROL")); 
                lista.add(vdto);
            }
            conn.close();
        } catch (Exception e) {
            try {
                conn.close();
                System.out.println("ERROR Listar Vendedor: "+e.getMessage());
            } catch (SQLException ex) {                
            }
            
        }
        return lista;
    }
    
    public boolean agregarVendedor(VendedorDTO vdto){
        boolean flat = false;
        
        PreparedStatement st = null;
        String query = "INSERT INTO VENDEDOR (USUARIO,CLAVE,ROL,ID_VENDEDOR) VALUES (?,?,?,?)";
        try {  
                     
            conn = conMySQL.getConexion();
            st = conn.prepareStatement(query);
            st.setString(1, vdto.getUSUARIO());
            st.setString(2, vdto.getCLAVE());
            st.setString(3, vdto.getROL());
            st.setInt(4, vdto.getID_VENDEDOR());

            st.executeUpdate();
            //conn.commit();
            conn.close();
            flat = true;
        } catch (Exception e) {
            try {
                flat = false;
                conn.rollback();
                conn.close();
                System.out.println("ERROR agregarVendedor: "+e.getMessage());
            } catch (SQLException ex) {                
            }
        }
        
        return flat;
    }
    
    public boolean actualizarVendedor(VendedorDTO vdto){
        
        boolean flat = false;
        
        PreparedStatement st = null;
        String query = "UPDATE VENDEDOR SET USUARIO = ?, CLAVE = ?, ROL = ? where ID_VENDEDOR = ?";
        try {  
                     
            conn = conMySQL.getConexion();
            st = conn.prepareStatement(query);
            st.setString(1, vdto.getUSUARIO());
            st.setString(2, vdto.getCLAVE());
            st.setString(3, vdto.getROL());
            st.setInt(4, vdto.getID_VENDEDOR());
            st.executeUpdate();
            //cn.commit();
            conn.close();
            flat = true;
        } catch (Exception e) {
            try {
                flat = false;
                conn.rollback();
                conn.close();
                System.out.println("ERROR Actualizar Vendedor: "+e.getMessage());
            } catch (SQLException ex) {                
            }
            
        }
        
        return flat;
    }
    
    public VendedorDTO buscarVendedorId(int ID){
        
        PreparedStatement st = null;
        ResultSet rs = null;
        String query = "SELECT ID_VENDEDOR, USUARIO, CLAVE, ROL FROM VENDEDOR WHERE ID_VENDEDOR = ?";
        VendedorDTO vdto = null;
        
        try {            
            conn = conMySQL.getConexion();
            st = conn.prepareStatement(query);
            st.setInt(1, ID);
            rs = st.executeQuery();
            if (rs.next()) {
                vdto = new VendedorDTO();
                vdto.setID_VENDEDOR(rs.getInt("ID_VENDEDOR"));
                vdto.setUSUARIO(rs.getString("USUARIO"));
                vdto.setCLAVE(rs.getString("CLAVE"));
                vdto.setROL(rs.getString("ROL"));                
            }
            conn.close();
        } catch (Exception e) {
            try {
                conn.close();
                System.out.println("ERROR validar Vendedor: "+e.getMessage());
            } catch (SQLException ex) {                
            }
        }
        return vdto;
        
    }
    
    public boolean eliminarVendedor(int ID){
        
        boolean flat = false;
        
        PreparedStatement st = null;
        String query = "DELETE FROM VENDEDOR WHERE ID_VENDEDOR = ?";
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
                System.out.println("ERROR eliminar Vendedor: "+e.getMessage());
            } catch (SQLException ex) {                
            }
            
        }
        
        return flat;
    } 
        
    }