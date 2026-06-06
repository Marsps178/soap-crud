package cibertec.pe.main;

import cibertec.pe.config.SoapClientConfig;
import pe.cibertec.wsclient.Producto;
import pe.cibertec.wsclient.ProductoImplements;

public class MainActualizarProductos {
    public static void main(String[] args) {
        ProductoImplements service = SoapClientConfig.getService();
        int updateId = 1; // ID de ejemplo
        
        Producto p = new Producto();
        p.setNombre("Producto Modificado Prueba");
        p.setPrecio(150.50);
        p.setCantidad(25);
        
        String respuesta = service.updateProducto(updateId, p);
        System.out.println("Respuesta del servidor: " + respuesta);
    }
}
