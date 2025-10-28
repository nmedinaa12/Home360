package MicroservicioUsuarios.configurations.beans;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI springHomeOpenAPI() {
        final String securitySchemeName = "bearerAuth";

        return new OpenAPI()
                .info(new Info()
                        .title("APIs MicroservicioUsuarios")
                        .description("Documentación de las APIs del Microservicio de Usuarios")
                        .version("v1.0.0")
                        .contact(new Contact()
                                .name("Nicolás Medina")
                                .email("nicofeme2015@gmail.com")
                                .url("-")
                        )
                        .license(new License().name("Apache 2.0").url("http://springdoc.org"))
                )
                // 🔐 Agrega esquema de seguridad tipo Bearer JWT
                .addSecurityItem(new SecurityRequirement().addList(securitySchemeName))
                .components(new io.swagger.v3.oas.models.Components()
                        .addSecuritySchemes(securitySchemeName,
                                new SecurityScheme()
                                        .name(securitySchemeName)
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")
                                        .description("Introduce el token JWT con el prefijo 'Bearer '")));
    }
}
