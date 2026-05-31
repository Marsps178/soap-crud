package cibertec.pe.service;

import cibertec.pe.dto.ProductoRequest;
import cibertec.pe.dto.ProductoResponse;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public interface IProductoService {

    @WebMethod
    List<ProductoResponse> getAllProductos();

    @WebMethod
    ProductoResponse getProductoById(Integer id);

    @WebMethod
    ProductoResponse createProducto(ProductoRequest request);

    @WebMethod
    ProductoResponse updateProducto(Integer id, ProductoRequest request);

    @WebMethod
    ProductoResponse deleteProducto(Integer id);
}
