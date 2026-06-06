package cibertec.pe.main;

import cibertec.pe.config.SoapClientConfig;
import pe.cibertec.wsclient.Producto;
import pe.cibertec.wsclient.ProductoImplements;

public class MainBuscarProducto {
    public static void main(String[] args) {
        ProductoImplements service = SoapClientConfig.getService();
        int searchId = 1; // ID de ejemplo
        Producto p = service.findProducto(searchId);
        if (p != null) {
            System.out.println("Producto encontrado:");
            System.out.println("ID: " + p.getCodigo() + " | Nombre: " + p.getNombre() + " | Precio: " + p.getPrecio() + " | Cantidad: " + p.getCantidad());
        } else {
            System.out.println("Producto con ID " + searchId + " no encontrado.");
        }
    }
}
