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
public class ProductoDTO {
    
    private int Idproducto;
    private String nombre;
    private String precio;
    private String costo;
    private String unid_medida;
    private String codigo;
    private String estado;
    private String stock;

    public ProductoDTO() {
    }

    public ProductoDTO(int Idproducto, String nombre, String precio, String costo, String unid_medida, String codigo, String estado, String stock) {
        this.Idproducto = Idproducto;
        this.nombre = nombre;
        this.precio = precio;
        this.costo = costo;
        this.unid_medida = unid_medida;
        this.codigo = codigo;
        this.estado = estado;
        this.stock = stock;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public int getIdproducto() {
        return Idproducto;
    }

    public void setIdproducto(int Idproducto) {
        this.Idproducto = Idproducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public String getUnid_medida() {
        return unid_medida;
    }

    public void setUnid_medida(String unid_medida) {
        this.unid_medida = unid_medida;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
}
