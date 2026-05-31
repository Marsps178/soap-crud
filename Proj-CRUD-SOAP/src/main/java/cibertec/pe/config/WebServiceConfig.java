package cibertec.pe.config;

import cibertec.pe.service.ProductoImplement;
import jakarta.annotation.PostConstruct;
import jakarta.xml.ws.Endpoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebServiceConfig {

    private static final Logger log = LoggerFactory.getLogger(WebServiceConfig.class);

    private final ProductoImplement productoService;

    public WebServiceConfig(ProductoImplement productoService) {
        this.productoService = productoService;
    }

    @PostConstruct
    public void publishEndpoint() {
        String url = "http://localhost:1516/ws/productos";
        Endpoint.publish(url, productoService);
        log.info("Servicio SOAP publicado en: {}", url);
    }
}
