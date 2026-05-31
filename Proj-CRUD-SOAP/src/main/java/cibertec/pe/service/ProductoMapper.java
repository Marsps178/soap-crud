package cibertec.pe.service;

import cibertec.pe.dto.ProductoRequest;
import cibertec.pe.dto.ProductoResponse;
import cibertec.pe.entity.Producto;

public class ProductoMapper {

    public static Producto toEntity(ProductoRequest request) {
        Producto producto = new Producto();
        producto.setNombre(request.getNombre());
        producto.setPrecio(request.getPrecio());
        return producto;
    }

    public static ProductoResponse toResponse(Producto producto) {
        ProductoResponse response = new ProductoResponse();
        response.setId(producto.getId());
        response.setNombre(producto.getNombre());
        response.setPrecio(producto.getPrecio());
        response.setSuccess(true);
        return response;
    }

    public static ProductoResponse toResponse(Producto producto, String mensaje) {
        ProductoResponse response = toResponse(producto);
        response.setMensaje(mensaje);
        return response;
    }

    public static ProductoResponse toErrorResponse(String mensaje) {
        ProductoResponse response = new ProductoResponse();
        response.setMensaje(mensaje);
        response.setSuccess(false);
        return response;
    }
}
