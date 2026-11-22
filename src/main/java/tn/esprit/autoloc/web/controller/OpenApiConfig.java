package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI autolocOpenApi() {
        return new OpenAPI().info(new Info().title("AutoLoc API")
                .description("API REST de gestion de location de véhicules")
                .version("1.0.0"));
    }

    @Bean
    public GroupedOpenApi allApi() {
        return GroupedOpenApi.builder()
                .group("1. Tous les endpoints")
                .pathsToMatch("/**")
                .build();
    }

    @Bean
    public GroupedOpenApi vehiculeApi() {
        return GroupedOpenApi.builder()
                .group("2. Véhicules")
                .pathsToMatch("/vehicules/**")
                .build();
    }

    @Bean
    public GroupedOpenApi agenceApi() {
        return GroupedOpenApi.builder()
                .group("3. Agences")
                .pathsToMatch("/agences/**")
                .build();
    }

    @Bean
    public GroupedOpenApi clientApi() {
        return GroupedOpenApi.builder()
                .group("4. Clients")
                .pathsToMatch("/clients/**")
                .build();
    }

    @Bean
    public GroupedOpenApi contratApi() {
        return GroupedOpenApi.builder()
                .group("5. Contrats")
                .pathsToMatch("/contrats/**")
                .build();
    }

    @Bean
    public GroupedOpenApi employeApi() {
        return GroupedOpenApi.builder()
                .group("6. Employés")
                .pathsToMatch("/employes/**")
                .build();
    }

    @Bean
    public GroupedOpenApi equipementApi() {
        return GroupedOpenApi.builder()
                .group("7. Équipements")
                .pathsToMatch("/equipements/**")
                .build();
    }

    @Bean
    public GroupedOpenApi paiementApi() {
        return GroupedOpenApi.builder()
                .group("8. Paiements")
                .pathsToMatch("/paiements/**")
                .build();
    }
}