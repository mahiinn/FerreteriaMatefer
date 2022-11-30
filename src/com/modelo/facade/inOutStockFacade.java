package com.modelo.facade;

import com.conexion.Conexion;
import com.controlador.dao.CtrlEntradaDao;
import com.controlador.dao.CtrlSalidaDao;
import com.modelo.Entrada;
import com.modelo.Salida;
import javax.swing.table.DefaultTableModel;

public class inOutStockFacade {

    private CtrlEntradaDao ced;
    private CtrlSalidaDao csd;
    private final Conexion con;

    public inOutStockFacade() {

        con = new Conexion();
        ced = new CtrlEntradaDao();
        csd = new CtrlSalidaDao();

    }

    public int registrarNuevaEntrada(Entrada obj) {

        int res = ced.registrarEntrada(obj.getFactura(),
                obj.getNoProducto(), obj.getFecha(),
                obj.getCantidad(), obj.getId(), obj.getIdTypeUser());

        return res;

    }
    public DefaultTableModel getDatosEntradas(){
        
        return ced.getDatosEntradas();
    
    }
    
    public int registrarNuevaSalida(Salida obj){
        
//                obj.getNoProducto(), obj.getFecha(),
//                obj.getCantidad(), obj.getId(), obj.getIdTypeUser());
//
    return 0// csd.registrarSalida(obj.getMotivo(),
            ;
        
    }
}
