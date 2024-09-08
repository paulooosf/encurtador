package io.github.paulooosf.encurtador.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    OpenAPI myOpenApi() {
        Contact contact = new Contact();
        contact.setEmail("paulooosf@gmail.com");
        contact.setName("Paulo Henrique");
        contact.setUrl("https://paulooosf.github.io");

        License apacheLicense = new License().name("Apache License").url("https://www.apache.org/license/LICENSE-2.0");

        Info info = new Info()
                .title("API de encurtamento de links").version("1.0").contact(contact)
                .description("O projeto foi feito com o intuito de tornar links extensos em links menores.")
                .license(apacheLicense);

        return new OpenAPI().info(info);
    }
}
