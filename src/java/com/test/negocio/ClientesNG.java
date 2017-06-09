/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.negocio;


import com.sun.javafx.scene.control.skin.VirtualFlow;
import com.test.conexion.conMySQL;
import com.test.dto.ClienteDTO;
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
public class ClientesNG {
    
    private Connection conn;
    
    public List<ClienteDTO> listarCliente(){
    List<ClienteDTO> lista = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        
        String query = "select Idclientes, Nombres, Appaterno, Dni from clientes";
        ClienteDTO cdto = null;
        try {
            lista = new ArrayList<>();
            conn = conMySQL.getConexion();
            st = conn.prepareStatement(query);
            rs = st.executeQuery();
            
            while (rs.next()) {
                
                cdto = new ClienteDTO();
                cdto.setIdclientes(rs.getInt("Idclientes"));
                cdto.setNombres(rs.getString("Nombres"));
                cdto.setAppaterno(rs.getString("Appaterno"));
                cdto.setDni(rs.getString("Dni"));
                lista.add(cdto);
            }
            
            conn.close();
            
        } catch (Exception e) {
            try {
                conn.close();
                System.out.println("ERROR Listar Vendedor: "+e.getMessage());
            } catch (Exception ex) {
                
            }  
        }
        return lista;
    }
    
    public boolean agregarCliente(ClienteDTO cdto){
        boolean flat = false;
        PreparedStatement st = null;
        String query = "insert into clientes (Idclientes,Nombres,Appaterno,Dni)values(?,?,?,?)";
        try {
            conn = conMySQL.getConexion();
            st = conn.prepareStatement(query);
            st.setInt(1, cdto.getIdclientes());
            st.setString(2, cdto.getNombres());
            st.setString(3, cdto.getAppaterno());
            st.setString(4, cdto.getDni());
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
    
    public boolean actualizarCliente(ClienteDTO cdto){
        boolean flat = false;
        PreparedStatement st = null;
        String query = "update clientes set Nombres = ?, Appaterno = ?, Dni = ? where Idclientes = ?";
        try {
            conn = conMySQL.getConexion();
            st = conn.prepareStatement(query);
            st.setString(1, cdto.getNombres());
            st.setString(2, cdto.getAppaterno());
            st.setString(3, cdto.getDni());
             st.setInt(4, cdto.getIdclientes());
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
    
    public ClienteDTO buscarClienteId(int ID){
        PreparedStatement st = null;
        ResultSet rs = null;
        String query = "select Idclientes, Nombres, Appaterno, Dni from clientes where Idclientes = ?";
        ClienteDTO cdto = null;
        try {
            conn = conMySQL.getConexion();
            st = conn.prepareStatement(query);
            st.setInt(1, ID);
            rs = st.executeQuery();
            if (rs.next()) {
                cdto = new ClienteDTO();
                cdto.setIdclientes(rs.getInt("Idclientes"));
                cdto.setNombres(rs.getString("Nombres"));
                cdto.setAppaterno(rs.getString("Appaterno"));
                cdto.setDni(rs.getString("Dni"));
            }
            conn.close();
        } catch (Exception e) {
            try {
                conn.close();
                System.out.println("ERROR validar Vendedor: "+e.getMessage());
            } catch (SQLException ex) {                
            }
        }
                
        return cdto;
    }
    
    public boolean eliminarCliente(int ID){
        boolean flat = false;
        
        PreparedStatement st = null;
        String query = "delete from clientes where Idclientes = ?";
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