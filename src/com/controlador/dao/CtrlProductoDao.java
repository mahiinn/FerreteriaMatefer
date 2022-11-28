package com.controlador.dao;

import com.idao.IProductoDAO;
import com.conexion.Conexion;
import com.modelo.Producto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CtrlProductoDao implements IProductoDAO {

    private String sql;
    private PreparedStatement ps;
    private ResultSet rs;
    private final Conexion con;
    private final String SQL_INSERT_PRODUCTOS = "INSERT INTO product (referencia,descripcion,precio) values (?,?,?)";
    private final String SQL_UPDATE_PRODUCTOS = "UPDATE product SET referencia=?,descripcion=?, precio=? WHERE referencia=?";
    private final String SQL_DELETE_PRODUCTO = "DELETE from product WHERE referencia =?";

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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int verificarCodigoInventario(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
