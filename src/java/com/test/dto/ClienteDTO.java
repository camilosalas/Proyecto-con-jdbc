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
public class ClienteDTO {
    
    private int Idclientes;
    private String Nombres;
    private String Appaterno;
    private String Dni;

    public ClienteDTO() {
    }

    public ClienteDTO(int Idclientes, String Nombres, String Appaterno, String Dni) {
        this.Idclientes = Idclientes;
        this.Nombres = Nombres;
        this.Appaterno = Appaterno;
        this.Dni = Dni;
    }

    public String getDni() {
        return Dni;
    }

    public void setDni(String Dni) {
        this.Dni = Dni;
    }

    public int getIdclientes() {
        return Idclientes;
    }

    public void setIdclientes(int Idclientes) {
        this.Idclientes = Idclientes;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getAppaterno() {
        return Appaterno;
    }

    public void setAppaterno(String Appaterno) {
        this.Appaterno = Appaterno;
    }
    
    
    
}
