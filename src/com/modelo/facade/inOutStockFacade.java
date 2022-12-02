package com.modelo.facade;

import com.controlador.dao.CtrlEntradaDao;
import com.controlador.dao.CtrlSalidaDao;
import com.controlador.view.CtrlMovimientoView;
import com.modelo.Entrada;
import com.modelo.Salida;
import javax.swing.table.DefaultTableModel;

public class inOutStockFacade {

    private final CtrlEntradaDao ced;
    private final CtrlSalidaDao csd;
    private final CtrlMovimientoView cmv;

    public inOutStockFacade() {

        ced = new CtrlEntradaDao();
        csd = new CtrlSalidaDao();
        cmv = new CtrlMovimientoView();
    }

    public int registrarNuevaEntrada(Entrada obj) {

        int res = ced.registrarEntrada(obj.getFactura(),
                obj.getNoProducto(), obj.getFecha(),
                obj.getCantidad(), obj.getId(), obj.getIdTypeUser());

        return res;

    }

    public DefaultTableModel getDatosEntradas() {

        return ced.getDatosEntradas();

    }
    public DefaultTableModel getDatosSalida(){
        return csd.getDatosSalida();
    }

    public int registrarSalida(Salida obj) {

        return csd.registrarSalida(obj.getMotivo(), obj.getNoProducto(),
                obj.getFecha(), obj.getCantidad());

    }

    public DefaultTableModel getDatosInventario() {

        return cmv.getDatosInventario();

    }

    public int verificarStock(String codigo) {

        return csd.verificarStock(codigo);

    }
}
