package com.controlador.dao;

import com.conexion.Conexion;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CtrlSalidaDao {
    
    private PreparedStatement ps;
    private ResultSet rs;
    private final Conexion con;
    private DefaultTableModel DT;
    private final String 
            SQL_INSERT_SALIDA = "INSERT INTO salida "
            + "(sal_factura, sal_pro_codigo, sal_fecha, sal_cantidad) "
            + "values (?,?,?,?)";
    private final String 
            SQL_SELECT_SALIDA = "SELECT sal_factura, sal_fecha, sal_pro_codigo,"
            + " pro_descripcion, sal_cantidad "
            + "FROM salida INNER JOIN producto ON sal_pro_codigo = pro_codigo";
    
    public CtrlSalidaDao(){
        
        con = new Conexion();
        ps = null;
    
    }
    
    private DefaultTableModel setTitulosSalida(){
        
        DT = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            
        };
        DT.addColumn("N° de Factura");
        DT.addColumn("Fecha");
        DT.addColumn("Código de Producto");
        DT.addColumn("Descripción");
        DT.addColumn("Cantidad");
        return DT;
        
    }
    
    public DefaultTableModel getDatosSalida(){
        
        try {
            setTitulosSalida();
            ps = con.Connect().prepareStatement(SQL_SELECT_SALIDA);
            rs = ps.executeQuery();
            Object[] fila = new Object[5];
            while(rs.next()){
                fila[0] = rs.getString(1);
                fila[1] = rs.getDate(2);
                fila[2] = rs.getString(3);
                fila[3] = rs.getString(4);
                fila[4] = rs.getInt(5);
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
    
    public int registrarSalida(String motivo, String codigo, Date fecha, int cantidad){
        
        int res=0;
        try {
            ps = con.Connect().prepareStatement(SQL_INSERT_SALIDA);
            ps.setString(1, motivo);
            ps.setString(2, codigo);
            ps.setDate(3, fecha);
            ps.setInt(4, cantidad);
            res = ps.executeUpdate();
            if(res > 0){
                JOptionPane.showMessageDialog(null, "Salida realizada con éxito.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo registrar la salida.");
            System.err.println("Error al registrar la salida." +e.getMessage());
        } finally{
            ps = null;
            con.Disconnect();
        }
        return res;
        
    }
    
    public int verificarStock(String codigo){
        
        int res=0;
        try {
            ps = con.Connect().prepareStatement("SELECT inv_stock from inventario where inv_pro_codigo='"+codigo+"'");
            rs = ps.executeQuery();
            
            while(rs.next()){
                res = rs.getInt(1);
            }
            
        } catch (SQLException e) {
            System.err.println("Error al devolver cantidad de registros." +e.getMessage());
        } finally{
            ps = null;
            con.Disconnect();
        }
        return res;
        
    }
}
