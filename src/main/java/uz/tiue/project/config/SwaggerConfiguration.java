package uz.tiue.project.config;


import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {
    @Bean
    public OpenAPI openApi(){
        final String securitySchemeName = "Bearer Authentication";
        return new OpenAPI()
                .info(new Info()
                        .title("something")
                        .description("This project was created by eeslambec ")
                        .version("1.0.0")
                        .termsOfService("https://swagger.io")
                        .contact(new Contact()
                                .name("Islam")
                                .email("eeslambec@gmail.com")
                                .url("https://t.me/eeslambec")
                        )
                )
                .addSecurityItem(new SecurityRequirement()
                        .addList(securitySchemeName)
                ).components(new Components()
                        .addSecuritySchemes(securitySchemeName, new SecurityScheme()
                                .name   (securitySchemeName)
                                .bearerFormat("JWT")
                                .scheme("bearer")
                                .type(SecurityScheme.Type.HTTP)
                        ));
    }
}
