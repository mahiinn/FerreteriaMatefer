package com.controlador.view;

import com.conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class CtrlUserView {
    
    private PreparedStatement ps;
    private ResultSet rs;
    private final Conexion con;
    private DefaultTableModel DT;
    private final String SQL_SELECT_USERS = "SELECT u.idUser,u.fullname,u.username,t.nombre "
            + "FROM user AS u INNER JOIN Type_Users AS t ON u.Type_Users_id = t.id";
    private final String SQL_SELECT_TYPE_USERS = "SELECT nombre FROM Type_Users";
    private Statement st;
    
    public CtrlUserView() {
        ps = null;
        con = new Conexion();
    }
    
    private DefaultTableModel setTitulosUsers(){
        DT = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        DT.addColumn("Código");
        DT.addColumn("Nombre completo");
        DT.addColumn("Tipo de usuario");
        DT.addColumn("Nombre de usuario");
        return DT;
    }
    
    public DefaultTableModel getDatosUsers(){
        
        try {
            setTitulosUsers();
            ps = con.Connect().prepareStatement(SQL_SELECT_USERS);
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
    
    public ArrayList<String> getTypeUsers(){
        
        ArrayList <String> obj =new ArrayList<>();
        
        try{
            
            st = con.Connect().createStatement();
            rs = st.executeQuery(SQL_SELECT_TYPE_USERS);
            while(rs.next()){

                obj.add(rs.getString("nombre"));
                
            }
        }catch(SQLException e){
            
            System.err.println("Error al listar los datos."+e.getMessage());
            
        } finally{
            ps = null;
            rs = null;
            con.Disconnect();
        }
        return obj;
    }
}
