package com.controlador.dao;

import com.conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class CtrlBuscarProductoDao {
    
    private PreparedStatement ps;
    private ResultSet rs;
    private final Conexion con;
    private DefaultTableModel dt;
    private final String 
        SQL_BUSCAR_PRODUCTOS = "SELECT p.noProducto, p.referencia, p.descripcion, "
        + "m.movstock FROM producto AS p INNER JOIN movimiento AS m ON "
        + "p.noProducto = m.noProducto ORDER BY p.noProducto ASC";

    public CtrlBuscarProductoDao() {
        
        this.con = new Conexion();
        this.ps = null;
    }
    
    private DefaultTableModel setTitulosProductosBuscados(){
        dt = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            
        };
        dt.addColumn("Código");
        dt.addColumn("Referencia");
        dt.addColumn("Descripción");
        dt.addColumn("Stock Actual");
        
        return dt;
    }
    
    public DefaultTableModel getDatosProductosBusqueda(){
        
        try {
            setTitulosProductosBuscados();
            ps = con.Connect().prepareStatement(SQL_BUSCAR_PRODUCTOS);
            rs = ps.executeQuery();
            Object[] fila = new Object[4];
            while(rs.next()){
                fila[0] = rs.getString(1);
                fila[1] = rs.getString(2);
                fila[2] = rs.getString(3);
                fila[3] = rs.getInt(4);
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
    
    public DefaultTableModel getDatoP(int crt, String inf){
        
        String SQL;
        if (crt==2){
            SQL = "SELECT p.noProducto, p.descripcion, movstock"
                    + "FROM producto AS p INNER JOIN movimiento ON "
                    + "p.noProducto = noProducto ORDER BY p.noProducto ASC'"+inf+"'";
        }
        else {
            SQL = "SELECT p.noProducto, p.descripcion, movstock"
                    + "FROM producto AS p INNER JOIN movimiento ON "
                    + "p.noProducto = noProducto where p.descripcion like '" +inf + "%'";
        }
        try {
            setTitulosProductosBuscados();
            ps = con.Connect().prepareStatement(SQL);
            rs = ps.executeQuery();
            Object[] fila = new Object[4];
            while(rs.next()){
                fila[0] = rs.getString(1);
                fila[1] = rs.getString(2);
                fila[2] = rs.getInt(3);
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
