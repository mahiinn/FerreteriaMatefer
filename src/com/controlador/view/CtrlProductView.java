package com.controlador.view;

import com.conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class CtrlProductView {
    
    private PreparedStatement ps;
    private ResultSet rs;
    private final Conexion con;
    private DefaultTableModel DT;
    private final String SQL_SELECT_PRODUCTOS = "SELECT * FROM producto";
    
    public CtrlProductView() {
        ps = null;
        con = new Conexion();
    }
    
    private DefaultTableModel setTitulosProductos(){
        DT = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            
        };
        DT.addColumn("Código");
        DT.addColumn("Referencia");
        DT.addColumn("Descripción");
        DT.addColumn("Precio");
        return DT;
    }
    
    public DefaultTableModel getDatosProductos(){
        
        try {
            setTitulosProductos();
            ps = con.Connect().prepareStatement(SQL_SELECT_PRODUCTOS);
            rs = ps.executeQuery();
            Object[] fila = new Object[4];
            while(rs.next()){
                fila[0] = rs.getString(1);
                fila[1] = rs.getString(2);  
                fila[2] = rs.getString(3);  
                fila[3] = rs.getString(4);  
                DT.addRow(fila);
            }
        } catch (SQLException e) {
            
            System.err.println("Error al listar los datos."+e.getMessage());
            
        } finally{
            ps = null;
            rs = null;
            con.Disconnect();
        }
        return DT;
    }
    
}
