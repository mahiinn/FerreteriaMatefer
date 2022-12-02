package com.controlador.dao;

import com.idao.IProductoDAO;
import com.conexion.Conexion;
import com.modelo.Producto;
import com.modelo.Usuario;
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
    private final String SQL_INSERT_PRODUCTOS = "INSERT INTO producto "
            + "(referencia,descripcion,precio) values (?,?,?)";
    private final String SQL_UPDATE_PRODUCTOS = "UPDATE producto SET "
            + "referencia=?,descripcion=?, precio=? WHERE referencia=?";
    private final String SQL_DELETE_PRODUCTO = "DELETE from producto WHERE referencia =?";

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
        sql = "Select referencia from producto where referencia = '" + referencia + "';";
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
    public void insertarProductoInventario(String codigoProducto,Usuario usr) {
        
        try {
            
            ps = con.Connect().prepareStatement("CALL NUEVO_PRODUCTO"
                    + "('" + getCodigo(codigoProducto) + "', '" + usr.getUserName() + "', '" + usr.getTypeNombre() + "')");
            ps.executeQuery();
            
        } catch (SQLException e) {
            System.err.println("Error al insertar registro en la tabla inventario." + e.getMessage());
        } finally {
            ps = null;
            con.Disconnect();
        }
    }

    @Override
    public int verificarCodigoInventario(String codigo) {
        int res = 0;
        try {
            ps = con.Connect().prepareStatement("SELECT count(noProducto) from movimiento where noProducto='" + getCodigo(codigo) + "'");
            rs = ps.executeQuery();

            while (rs.next()) {
                res = rs.getInt(1);
            }

        } catch (SQLException e) {
            System.err.println("Error al devolver cantidad de registros." + e.getMessage());
        } finally {
            ps = null;
            con.Disconnect();
        }
        return res;
    }

    private int getCodigo(String referencia) {

        int codigo = 0;
        try {

            ps = con.Connect().prepareStatement("SELECT noProducto FROM producto WHERE referencia = '" + referencia + "';");
            rs = ps.executeQuery();
            while(rs.next()){
                codigo = rs.getInt(1);
            }
                
            return codigo;
            
        } catch (SQLException e) {

            System.err.println("Error al devolver." + e.getMessage());

        } finally {
            ps = null;
            con.Disconnect();
        }

        return codigo;
    }
}
