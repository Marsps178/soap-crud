package cibertec.pe.main;

import cibertec.pe.config.SoapClientConfig;
import pe.cibertec.wsclient.ProductoImplements;

public class MainEliminarProducto {
    public static void main(String[] args) {
        ProductoImplements service = SoapClientConfig.getService();
        int deleteId = 1; // ID de ejemplo
        String respuesta = service.deleteProducto(deleteId);
        System.out.println("Respuesta del servidor: " + respuesta);
    }
}
