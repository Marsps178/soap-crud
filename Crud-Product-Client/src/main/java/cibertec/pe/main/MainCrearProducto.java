package cibertec.pe.main;

import cibertec.pe.config.SoapClientConfig;
import pe.cibertec.wsclient.Producto;
import pe.cibertec.wsclient.ProductoImplements;

public class MainCrearProducto {
    public static void main(String[] args) {
        ProductoImplements service = SoapClientConfig.getService();

        Producto p = new Producto();
        p.setNombre("Teclaod 455");
        p.setPrecio(25);
        p.setCantidad(100);

        Producto creado = service.createProduct(p);
        System.out.println("Id Creado " + creado.getCodigo());
    }

}
