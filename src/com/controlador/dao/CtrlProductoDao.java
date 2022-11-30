package com.controlador.dao;

import com.idao.IProductoDAO;
import com.conexion.Conexion;
import com.modelo.Producto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class CtrlProductoDao implements IProductoDAO {

    private String sql;
    private PreparedStatement ps;
    private ResultSet rs;
    private final Conexion con;
    private DefaultTableModel DT;
    private final String 
            SQL_INSERT_PRODUCTOS = "INSERT INTO product "
            + "(referencia,descripcion,precio) values (?,?,?)";
    private final String 
            SQL_UPDATE_PRODUCTOS = "UPDATE product SET "
            + "referencia=?,descripcion=?, precio=? WHERE referencia=?";
    private final String 
            SQL_DELETE_PRODUCTO = "DELETE from product WHERE referencia =?";
    private final String 
            SQL_BUSCAR_PRODUCTOS = "SELECT p.noProduct, p.descripcion, "
            + "movstock FROM product AS p INNER JOIN movimiento ON "
            + "p.noProduct = noProduct ORDER BY p.noProduct ASC";

    public CtrlProductoDao() {
        ps = null;
        con = new Conexion();
    }

    @Override
    public boolean createProduct(Producto obj) {

        try {

            ps = con.Connect().prepareStatement(SQL_INSERT_PRODUCTOS);
            ps.setString(1, obj.getReferencia());
            ps.setString(2, obj.getDescripcion());
            ps.setDouble(3, obj.getPrecio());
            ps.execute();
            return true;

        } catch (SQLException e) {
            System.err.println("Error al registrar el producto." + e.getMessage());
            return false;
        } finally {
            ps = null;
            sql = null;
            con.Disconnect();
        }
    }

    @Override
    public int updateProduct(String codigo, String descripcion, String codigo_old, double precio) {

        int res = 0;
        try {

            ps = con.Connect().prepareStatement(SQL_UPDATE_PRODUCTOS);
            ps.setString(1, codigo);
            ps.setString(2, descripcion);
            ps.setDouble(3, precio);
            ps.setString(4, codigo_old);

            res = ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error al modificar los datos del producto." + e.getMessage());
        } finally {
            ps = null;
            con.Disconnect();
        }
        return res;
    }

    @Override
    public int deleteProduct(String referencia) {

        int res = 0;
        try {
            ps = con.Connect().prepareStatement(SQL_DELETE_PRODUCTO);
            ps.setString(1, referencia);
            res = ps.executeUpdate();
            //
        } catch (SQLException e) {
            //
            System.err.println("Error al eliminar producto." + e.getMessage());
        } finally {
            ps = null;
            con.Disconnect();
        }
        return res;
    }

    //metodo para comprobar la existencia del producto
    @Override
    public boolean existeProduct(String referencia) {

        boolean respuesta = false;
        sql = "Select referencia from product where referencia = '" + referencia + "';";
        Statement st;

        try {

            st = con.Connect().createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {

                respuesta = true;
            }

        } catch (SQLException e) {

            System.err.println("Error al consultar el producto " + e);

        } finally {

            ps = null;
            sql = null;
            con.Disconnect();

        }
        return respuesta;
    }

    @Override
    public void insertarProductoInventario(String codigoProducto) {
        int res;
        try {
            ps = con.Connect().prepareStatement("CALL NUEVO_PRODUCTO('"+codigoProducto+"')");
            ps.executeQuery();
        } catch (SQLException e) {
            System.err.println("Error al insertar registro en la tabla inventario." +e.getMessage());
        } finally{
            ps = null;
            con.Disconnect();
        }
    }

    @Override
    public int verificarCodigoInventario(String codigo) {
        int res=0;
        try {
            ps = con.Connect().prepareStatement("SELECT count(noProducto) from movimiento where noProduct='"+codigo+"'");
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
    
    private DefaultTableModel setTitulosProductosBuscados(){
        DT = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            
        };
        DT.addColumn("Código");
        DT.addColumn("Referencia");
        DT.addColumn("Descripción");
        DT.addColumn("Stock Actual");
        
        return DT;
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
                fila[2] = rs.getInt(3);
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
    
    public DefaultTableModel getDatoP(int crt, String inf){
        
        String SQL;
        if (crt==2){
            SQL = "SELECT pro_codigo, pro_descripcion, inv_stock "
                    + "FROM producto AS p INNER JOIN inventario ON "
                    + "pro_codigo = inv_pro_codigo where pro_codigo like '"+inf+"'";
        }
        else {
            SQL = "SELECT pro_codigo, pro_descripcion, inv_stock "
                    + "FROM producto INNER JOIN inventario ON "
                    + "pro_codigo = inv_pro_codigo where pro_descripcion like '" +inf + "%'";
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
