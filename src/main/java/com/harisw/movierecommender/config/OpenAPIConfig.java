package com.harisw.movierecommender.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfig {
    @Value("${harisw.openapi.dev-url}")
    private String devUrl;

    @Value("${harisw.openapi.prod-url}")
    private String prodUrl;


    @Bean
    public OpenAPI myOpenAPI() {
        Server devServer = new Server();
        devServer.setUrl(devUrl);
        devServer.setDescription("Server URL in Localhost");

        Server prodServer = new Server();
        prodServer.setUrl(prodUrl);
        prodServer.setDescription("Server URL in Production environment");

        Contact contact = new Contact();
        contact.setEmail("haristw16@gmail.com");
        contact.setName("haristw");
        contact.setUrl("https://github.com/harisw");

        License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

        Info info = new Info()
                .title("Movie Recommendation API")
                .version("1.0")
                .contact(contact)
                .description("This API exposes endpoints related to movie recommendation system")
                .license(mitLicense);
        return new OpenAPI().info(info).servers(List.of(devServer, prodServer));
    }
}
