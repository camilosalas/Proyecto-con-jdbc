/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.negocio;

import com.test.conexion.conMySQL;
import com.test.dto.ProveedorDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CAMILO SALAS
 */
public class ProveedorNG {
    
    private Connection conn;
    
    public List<ProveedorDTO> listarProveedor(){
        List<ProveedorDTO> lista = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        
        String query = "select idproveedor, nombre, apellido, dni, empresa, telefono, celular, correo from proveedor";
        ProveedorDTO prdto = null;
        
        try {
            
            lista = new ArrayList<>();
            conn = conMySQL.getConexion();
            st = conn.prepareStatement(query);
            rs = st.executeQuery();
            
            while (rs.next()) {
                
                prdto = new ProveedorDTO();
                prdto.setIdproveedor(rs.getInt("idproveedor"));
                prdto.setNombre(rs.getString("nombre"));
                prdto.setApellido(rs.getString("apellido"));
                prdto.setDni(rs.getString("dni"));
                prdto.setEmpresa(rs.getString("empresa"));
                prdto.setTelefono(rs.getString("telefono"));
                prdto.setCelular(rs.getString("celular"));
                prdto.setCorreo(rs.getString("correo"));
                
                lista.add(prdto);
               
            }
            
            conn.close();
            
        } catch (Exception e) {
            
            try {
                
                conn.close();
                System.out.println("ERROR Listar Proveedor: "+e.getMessage());
            } catch (Exception ex) {
            }
        }
        
        return lista;
        
    }
    
    public boolean agregarProveedor(ProveedorDTO prdto){
        
        boolean flat = false;
        PreparedStatement st = null;
        String query = "insert into proveedor (idproveedor, nombre, apellido, dni, empresa, telefono, celular, correo)values(?,?,?,?,?,?,?,?)";
        
        try {
            
            conn = conMySQL.getConexion();
            st = conn.prepareStatement(query);
            
            st.setInt(1, prdto.getIdproveedor());
            st.setString(2, prdto.getNombre());
            st.setString(3, prdto.getApellido());
            st.setString(4, prdto.getDni());
            st.setString(5, prdto.getEmpresa());
            st.setString(6, prdto.getTelefono());
            st.setString(7, prdto.getCelular());
            st.setString(8, prdto.getCorreo());
            
            st.executeUpdate();
            conn.close();
            flat = true;
            
        } catch (Exception e) {
            
            try {
                
                flat = false;
                conn.rollback();
                conn.close();
                System.out.println("ERROR agregar Proveedor: "+e.getMessage());
                
            } catch (Exception ex) {
            }
        }
        return flat;
    }
    
    public boolean actualizarProveedor(ProveedorDTO prdto){
        boolean flat = false;
        PreparedStatement st = null;
        String query = "update proveedor set nombre = ?, apellido = ?, dni = ?, empresa = ?, telefono = ?, celular = ?, correo = ? where idproveedor = ?";
        try {
            conn = conMySQL.getConexion();
            st = conn.prepareStatement(query);
            st.setString(1, prdto.getNombre());
            st.setString(2, prdto.getApellido());
            st.setString(3, prdto.getDni());
            st.setString(4, prdto.getEmpresa());
            st.setString(5, prdto.getTelefono());
            st.setString(6, prdto.getCelular());
            st.setString(7, prdto.getCorreo());
            st.setInt(8, prdto.getIdproveedor());
            st.executeUpdate();
            conn.close();
            flat = true;
            
        } catch (Exception e) {
            try {
                flat = false;
                conn.rollback();
                conn.close();
                System.out.println("ERROR Actualizar Proveedor: "+e.getMessage());
            } catch (Exception ex) {                
            }
            
        }
        return flat;
    }
    
    public ProveedorDTO buscarProveedorId(int ID){
        
        PreparedStatement st = null;
        ResultSet rs = null;
        
        String query = "select idproveedor, nombre, apellido, dni, empresa, telefono, celular, correo from proveedor where idproveedor = ?";
        ProveedorDTO prdto = null;
        try {
            conn = conMySQL.getConexion();
            st = conn.prepareStatement(query);
            st.setInt(1, ID);
            rs = st.executeQuery();
            if (rs.next()) {
                prdto = new ProveedorDTO();
                prdto.setIdproveedor(rs.getInt("idproveedor"));
                prdto.setNombre(rs.getString("nombre"));
                prdto.setApellido(rs.getString("apellido"));
                prdto.setDni(rs.getString("dni"));
                prdto.setEmpresa(rs.getString("empresa"));
                prdto.setTelefono(rs.getString("telefono"));
                prdto.setCelular(rs.getString("celular"));
                prdto.setCorreo(rs.getString("correo"));
            }
            conn.close();
        } catch (Exception e) {
            try {
                conn.close();
                System.out.println("ERROR al buscar Proveedor: "+e.getMessage());
            } catch (Exception ex) {                
            }
        }
                
        return prdto;
    }
    
    public boolean eliminarProveedor(int ID){
        
        boolean flat = false;
        PreparedStatement st = null;
        String query = "delete from proveedor where idproveedor = ?";
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
                System.out.println("ERROR eliminar Proveedor: "+e.getMessage());
            } catch (Exception ex) {                
            }
            
        }
        
    return flat;    
    }
    
}
