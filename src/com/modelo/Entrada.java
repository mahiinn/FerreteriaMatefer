package com.modelo;

import java.sql.Date;

public class Entrada {
    
    private int idEntrada; // id de la entrada
    private int id; //id de usuario que realizo la entrada
    private int idTypeUser; // id del tipo de usuario
    private String noProducto; //Codigo del producto
    private Date fecha; // Fecha y hora del movimiento
    private int cantidad; // cantidad que entró
    private String factura;

    public int getIdEntrada() {
        return idEntrada;
    }

    public void setIdEntrada(int idEntrada) {
        this.idEntrada = idEntrada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdTypeUser() {
        return idTypeUser;
    }

    public void setIdTypeUser(int idTypeUser) {
        this.idTypeUser = idTypeUser;
    }

    public String getNoProducto() {
        return noProducto;
    }

    public void setNoProducto(String noProducto) {
        this.noProducto = noProducto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }


    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getFactura() {
        return factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }
    
}
