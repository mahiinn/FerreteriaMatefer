package com.modelo;

public class Movimiento {
    
    private int cantidad; //cantidad del movimiento ya sea entrada o salida
    private String nombre; //nombre de la persona que realizo el movimiento
    private int id; //id de usuario que realizo el movimiento
    private String rol; //rol del usuario
    private String fecha; // Fecha y hora del movimiento
    private String tipoMov; // tipo de movimiento realizado
    private int stock; // stock despues del movimiento

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipoMov() {
        return tipoMov;
    }

    public void setTipoMov(String tipoMov) {
        this.tipoMov = tipoMov;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
}
