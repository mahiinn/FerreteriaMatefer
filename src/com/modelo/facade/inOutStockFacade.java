package com.modelo.facade;

import com.conexion.Conexion;


public class inOutStockFacade {
    
    
    private final Conexion con;
    
    public inOutStockFacade(){
        
        con = new Conexion();
    }
}
