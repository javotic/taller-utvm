package mx.com.utvm.taller.backend.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Directorio de Personas")
                        .version("1.0.0")
                        .description("Documentación del backend para el taller de Spring Boot y Angular.")
                        .contact(new Contact()
                                .name("Tu Nombre/Empresa")
                                .email("contacto@taller.com")));
    }
}