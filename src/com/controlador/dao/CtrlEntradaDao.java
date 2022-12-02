package com.controlador.dao;

import com.conexion.Conexion;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CtrlEntradaDao {

    private final Conexion con;
    private PreparedStatement ps;
    private DefaultTableModel DT;
    private ResultSet rs;

    private final String SQL_INSERT_ENTRADA = "INSERT INTO entrada "
            + "(idFactura, noProducto, fecha, cantidad, User_idUser, User_Type_User_id) "
            + "values (?,?,?,?,?,?)";

    private final String SQL_SELECT_ENTRADA = "SELECT \n"
            + "    e.idFactura, p.referencia, p.descripcion,e.fecha, e.cantidad, u.username, t.nombre\n"
            + "FROM\n"
            + "    entrada AS e\n"
            + "		INNER JOIN\n"
            + "	producto AS p ON e.noProducto = p.noProducto\n"
            + "        INNER JOIN\n"
            + "    user AS u ON User_idUser = u.idUser\n"
            + "        INNER JOIN\n"
            + "    Type_User AS t ON u.Type_User_id = t.id;";

    public CtrlEntradaDao() {

        ps = null;
        con = new Conexion();

    }

    private DefaultTableModel setTitulosEntrada() {

        DT = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };
        DT.addColumn("N° de Factura");
        DT.addColumn("Código de Producto");
        DT.addColumn("Descripción");
        DT.addColumn("Fecha");
        DT.addColumn("Cantidad");
        DT.addColumn("Usuario responsable");
        DT.addColumn("Rol del usuario");

        return DT;
    }

    public DefaultTableModel getDatosEntradas() {
        try {
            setTitulosEntrada();
            ps = con.Connect().prepareStatement(SQL_SELECT_ENTRADA);
            rs = ps.executeQuery();
            Object[] fila = new Object[7];
            while (rs.next()) {
                fila[0] = rs.getString(1);
                fila[1] = rs.getString(2);
                fila[2] = rs.getString(3);
                fila[3] = rs.getDate(4);
                fila[4] = rs.getInt(5);
                fila[5] = rs.getString(6);
                fila[6] = rs.getString(7);
                DT.addRow(fila);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar los datos." + e.getMessage());
        } finally {
            ps = null;
            rs = null;
            con.Disconnect();
        }
        return DT;
    }

    public int registrarEntrada(String nfactura, String noProducto,
            Date fecha, int cantidad, int idUser, int idTypeUser) {
        int res = 0;
        try {
            ps = con.Connect().prepareStatement(SQL_INSERT_ENTRADA);
            ps.setString(1, nfactura);
            ps.setInt(2, Integer.parseInt(noProducto));
            ps.setDate(3, fecha);
            ps.setInt(4, cantidad);
            ps.setInt(5, idUser);
            ps.setInt(6, idTypeUser);
            res = ps.executeUpdate();
            
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Entrada realizada con éxito.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo registrar la entrada.");
            System.err.println("Error al registrar la entrada." + e.getMessage());
        } finally {
            ps = null;
            con.Disconnect();
        }
        return res;
    }
}
