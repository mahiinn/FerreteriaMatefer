package com.modelo;

public class Salida {
    
    private int idSalida;
    private int id; //id de usuario que realizo la salida
    private int idTypeUser; //rol del usuario
    private String noProducto; // codigo del producto (Referencia)
    private String fecha; // Fecha y hora del movimiento
    private int cantidad; // cantidad que salio
    private String motivo; // motivo de la salida

    public int getIdSalida() {
        return idSalida;
    }

    public void setIdSalida(int idSalida) {
        this.idSalida = idSalida;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
    
    
}
