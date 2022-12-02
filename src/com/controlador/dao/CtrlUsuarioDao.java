package com.controlador.dao;

import com.idao.IUsuarioDAO;
import com.conexion.Conexion;
import com.modelo.Usuario;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CtrlUsuarioDao implements IUsuarioDAO {

    //Sentencias SQL
    private String sql;

    //Registro de usuarios
    private final String SQL_CREATE_USERS = "INSERT INTO User (fullname,"
            + "Type_User_id,password,username) VALUES(?,?,?,?)";

    //Actualizacion de usuarios
    private final String SQL_UPDATE_USERS = "UPDATE user SET fullname=?, "
            + "Type_User_id=?, password=?, username=? WHERE username=?";

    //Loguear usuario
    private final String SQL_READ_USERS = "SELECT \n"
            + "    u.idUser,\n"
            + "    u.fullname,\n"
            + "    u.username,\n"
            + "    u.Type_User_id,\n"
            + "    u.password,\n"
            + "    t.nombre\n"
            + "FROM\n"
            + "    user AS u\n"
            + "        INNER JOIN\n"
            + "    Type_User AS t ON u.Type_User_id = t.id\n"
            + "WHERE\n"
            + "    username = ?;";
    
    // Eliminar usuario
    private final String SQL_DELETE_PRODUCTO = "DELETE from user WHERE username =?";
    
    // Change password
    private final String SQL_CHANGE_PASSWORD = "UPDATE user SET password=? WHERE username=?";
    
    // Change username
    private final String SQL_CHANGE_USERNAME = "UPDATE user SET username=? WHERE username=?";
    
    // Change both (username and password)
    private final String SQL_CHANGE_BOTH = "UPDATE user SET username= ?, password=? WHERE username=?";
    
    //Clases para ejecutar las sentencias
    private PreparedStatement ps;
    private ResultSet rs;
    private final Conexion con;

    public CtrlUsuarioDao() {
        ps = null;
        con = new Conexion();
    }

    @Override
    public boolean signinUser(Usuario obj) {

        try {
            ps = con.Connect().prepareStatement(SQL_CREATE_USERS);
            ps.setString(1, obj.getFullname());
            ps.setInt(2, obj.getTypeUserId());
            ps.setString(3, obj.getPassword());
            ps.setString(4, obj.getUserName());
            ps.execute();
            return true;

        } catch (SQLException ex) {

            Logger.getLogger(CtrlUsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        } finally {
            ps = null;
            rs = null;
            con.Disconnect();
        }

    }

    @Override
    public boolean loginUser(Usuario obj) {

        try {

            ps = con.Connect().prepareStatement(SQL_READ_USERS);
            //System.out.println(obj.getUserName());
            ps.setString(1, obj.getUserName());
            rs = ps.executeQuery();

            // Validar si el usuario existe
            if (rs.next()) {

                // Validar contraseña
                if (obj.getPassword().equals(rs.getString(5))) {

                    obj.setIdUser(rs.getInt(1));
                    obj.setFullname(rs.getString(2));
                    obj.setUserName(rs.getString(3));
                    obj.setTypeUserId(rs.getInt(4));
                    obj.setTypeNombre(rs.getString(6));
                    return true;

                } else {

                    return false;
                }
            }

            return false;

        } catch (SQLException ex) {

            Logger.getLogger(CtrlUsuarioDao.class.getName()).log(Level.SEVERE, null, ex);

            return false;

        } finally {
            ps = null;
            rs = null;
            con.Disconnect();
        }
    }

    @Override
    public int actualizar(Usuario obj, String username_old) {

        String fullname = obj.getFullname();
        String username = obj.getUserName();
        String password = obj.getPassword();
        int typeUser = obj.getTypeUserId();

        int res = 0;
        try {
            ps = con.Connect().prepareStatement(SQL_UPDATE_USERS);
            ps.setString(1, fullname);
            ps.setInt(2, typeUser);
            ps.setString(3, password);
            ps.setString(4, username);
            ps.setString(5, username_old);

            res = ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error al modificar los datos del producto." + e.getMessage());
        } finally {
            ps = null;
            con.Disconnect();
        }
        return res;
    }

    //Metodo para comprobar la existencia de usuario
    @Override
    public boolean existeUser(String username) {

        boolean respuesta = false;
        sql = "Select username from user where username = '" + username + "';";
        Statement st;
        try {

            st = con.Connect().createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {

                respuesta = true;
            }

        } catch (SQLException e) {

            System.err.println("Error al consultar el usuario " + e);

        } finally {

            ps = null;
            sql = null;
            con.Disconnect();

        }
        return respuesta;
    }

    @Override
    
    public int eliminar(String id) {
        int res = 0;
        try {
            ps = con.Connect().prepareStatement(SQL_DELETE_PRODUCTO);
            ps.setString(1, id);
            res = ps.executeUpdate();
            //
        } catch (SQLException e) {
            //
            System.err.println("Error al eliminar el usuario." + e.getMessage());
        } finally {
            ps = null;
            con.Disconnect();
        }
        return res;
    }

    @Override
    public int changePassword(String username, String newPassword) {
        
        int res = 0;
        try {
            
            ps = con.Connect().prepareStatement(SQL_CHANGE_PASSWORD);
            ps.setString(1, newPassword);
            ps.setString(2, username);
           
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
    public int changeUsername(String username_old, String username_new) {

        int res = 0;
        
        try {
            
            ps = con.Connect().prepareStatement(SQL_CHANGE_USERNAME);
            ps.setString(1, username_new);
            ps.setString(2, username_old);

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
    public int changeBoth(String username_old, String username_new, String newPassword) {

        int res = 0;
        
        try {
            
            ps = con.Connect().prepareStatement(SQL_CHANGE_BOTH);
            ps.setString(1, username_new);
            ps.setString(2, newPassword);
            ps.setString(3, username_old);

            res = ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error al modificar los datos del producto." + e.getMessage());
        } finally {
            ps = null;
            con.Disconnect();
        }
        return res;
    }
    
}
