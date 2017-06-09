/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.dto;

/**
 *
 * @author CAMILO SALAS
 */
public class ProveedorDTO {
    
    private String nombre;
    private String apellido;
    private String dni;
    private String empresa;
    private String telefono;
    private String celular;
    private String correo;
    private int idproveedor;

    public ProveedorDTO() {
    }

    public ProveedorDTO(String nombre, String apellido, String dni, String empresa, String telefono, String celular, String correo, int idproveedor) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.empresa = empresa;
        this.telefono = telefono;
        this.celular = celular;
        this.correo = correo;
        this.idproveedor = idproveedor;
    }

    public int getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(int idproveedor) {
        this.idproveedor = idproveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    
    
    
    
    
}
