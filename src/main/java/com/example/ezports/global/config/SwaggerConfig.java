package com.example.ezports.global.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class SwaggerConfig {
    @Value("${swagger.server.url}")
    private String serverURL;

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("EZPORTS")
                .pathsToMatch("/**")
                .build();
    }

    @Bean
    public OpenAPI openAPI() {
        Server server = new Server();
        server.setUrl(this.serverURL);
        server.setDescription("EZports API server");
        List<Server> servers = new ArrayList<>();
        servers.add(server);

        return new OpenAPI()
                .info(
                    new Info()
                    .title("EZports API")
                    .version("1.0.0")
                )
                .servers(servers);
    }
}
