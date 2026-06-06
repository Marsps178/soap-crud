package cibertec.pe.main;

import cibertec.pe.config.SoapClientConfig;
import pe.cibertec.wsclient.Producto;
import pe.cibertec.wsclient.ProductoImplements;
import java.util.List;

public class MainListarProductos {
    public static void main(String[] args) {
        ProductoImplements service = SoapClientConfig.getService();
        List<Producto> lista = service.getAllProducts();
        if (lista == null || lista.isEmpty()) {
            System.out.println("No hay productos.");
        } else {
            System.out.println("=== LISTA DE PRODUCTOS ===");
            for (Producto p : lista) {
                System.out.println("ID: " + p.getCodigo() + " | Nombre: " + p.getNombre() + " | Precio: " + p.getPrecio() + " | Cantidad: " + p.getCantidad());
            }
        }
    }
}
