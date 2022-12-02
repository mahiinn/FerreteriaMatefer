package com.idao;

import com.modelo.Producto;
import com.modelo.Usuario;

public interface IProductoDAO {
    
    public boolean createProduct(Producto obj);
    public int updateProduct(String codigo, String descripcion, String codigo_old,double precio);
    public int deleteProduct(String referencia);
    public void insertarProductoInventario(String codigoProducto,Usuario usr);
    public int verificarCodigoInventario(String codigo);
    public boolean existeProduct(String referencia);
    
}
