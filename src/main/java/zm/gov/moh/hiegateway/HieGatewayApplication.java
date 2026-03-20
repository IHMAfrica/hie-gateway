package zm.gov.moh.hiegateway;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        servers = @Server(url = "http://localhost:7080", description = "Local server"),
        info = @Info(title = "HIE API Gateway", version = "2.0", description = "HIE API Gateway Service API")
)
public class HieGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(HieGatewayApplication.class, args);
    }

}
