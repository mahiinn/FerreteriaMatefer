package com.controlador.view;

import com.conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class CtrlMovimientoView {
    private PreparedStatement ps;
    private ResultSet rs;
    private final Conexion con;
    private DefaultTableModel dt;
    private final String 
            SQL_SELECT_MOVIMIENTO = "SELECT m.noProducto, p.descripcion, "
            + "m.moventradas, m.movsalidas, m.movstock FROM movimiento "
            + "AS m INNER JOIN producto AS p ON m.noProducto = p.noProducto";
    
    public CtrlMovimientoView(){
        ps = null;
        con = new Conexion();
    }
    
    private DefaultTableModel setTitulosInventario(){
        dt = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            
        };
        dt.addColumn("Codigo");
        dt.addColumn("Descripción");
        dt.addColumn("Entrada");
        dt.addColumn("Salida");
        dt.addColumn("Stock");
        return dt;
    }
    
    public DefaultTableModel getDatosInventario(){
        try {
            setTitulosInventario();
            ps = con.Connect().prepareStatement(SQL_SELECT_MOVIMIENTO);
            rs = ps.executeQuery();
            Object[] fila = new Object[5];
            while(rs.next()){
                fila[0] = rs.getString(1);
                fila[1] = rs.getString(2);
                fila[2] = rs.getInt(3);
                fila[3] = rs.getInt(4);
                fila[4] = rs.getInt(5);
                dt.addRow(fila);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar los datos."+e.getMessage());
        } finally{
            ps = null;
            rs = null;
            con.Disconnect();
        }
        return dt;
    }
}
