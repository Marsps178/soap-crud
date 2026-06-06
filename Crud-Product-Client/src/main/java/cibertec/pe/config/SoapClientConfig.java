package cibertec.pe.config;

import pe.cibertec.wsclient.ProductoImplements;
import pe.cibertec.wsclient.ProductoImplementsService;

public class SoapClientConfig {
    public static ProductoImplements getService(){
        ProductoImplementsService service = new ProductoImplementsService();
        return service.getProductoImplementsPort();
    }


}
