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
public class VendedorDTO {
    
   private String USUARIO;
   private String CLAVE;
   private String ROL;
   private int ID_VENDEDOR;

    public VendedorDTO() {
    }

    public VendedorDTO(String USUARIO, String CLAVE, String ROL, int ID_VENDEDOR) {
        this.USUARIO = USUARIO;
        this.CLAVE = CLAVE;
        this.ROL = ROL;
        this.ID_VENDEDOR = ID_VENDEDOR;
    }

    
    public String getUSUARIO() {
        return USUARIO;
    }

    public void setUSUARIO(String USUARIO) {
        this.USUARIO = USUARIO;
    }

    public String getCLAVE() {
        return CLAVE;
    }

    public void setCLAVE(String CLAVE) {
        this.CLAVE = CLAVE;
    }

    public String getROL() {
        return ROL;
    }

    public void setROL(String ROL) {
        this.ROL = ROL;
    }

    public int getID_VENDEDOR() {
        return ID_VENDEDOR;
    }

    public void setID_VENDEDOR(int ID_VENDEDOR) {
        this.ID_VENDEDOR = ID_VENDEDOR;
    }

   
}
