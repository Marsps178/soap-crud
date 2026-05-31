package cibertec.pe;

import java.util.List;

import jakarta.jws.WebService;

@WebService
public interface IProductoService {

    public List<Producto> getAllProductos();
    public Producto createProducto(Producto producto);
    public Producto getProductoById(Integer id);
    public String updateProducto(Integer id, Producto producto);
    public String deleteProducto(Integer id);

}
