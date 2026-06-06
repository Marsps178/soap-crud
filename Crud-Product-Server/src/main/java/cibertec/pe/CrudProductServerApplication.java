package cibertec.pe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import jakarta.xml.ws.Endpoint;



@SpringBootApplication
public class CrudProductServerApplication {

	public static void main(String[] args) {
		//SpringApplication.run(CrudProductServerApplication.class, args);

		ConfigurableApplicationContext context = SpringApplication.run(CrudProductServerApplication.class, args);
		ProductoImplements service = context.getBean(ProductoImplements.class);

		Endpoint.publish("http://localhost:8085/ws/prod", service);

	}

}
