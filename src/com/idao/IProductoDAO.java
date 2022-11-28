package com.idao;

import com.modelo.Producto;

public interface IProductoDAO {
    
    public boolean createProduct(Producto obj);
    public int updateProduct(String codigo, String descripcion, String codigo_old,double precio);
    public int deleteProduct(String referencia);
    public void insertarProductoInventario(String codigoProducto);
    public int verificarCodigoInventario(String codigo);
    public boolean existeProduct(String referencia);
    
}
