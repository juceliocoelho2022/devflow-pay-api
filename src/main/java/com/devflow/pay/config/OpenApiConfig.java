package com.devflow.pay.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI devFlowOpenAPI() {

        Server localServer = new Server()
                .url("http://localhost:8080")
                .description("Servidor Local");

        Server devServer = new Server()
                .url("https://dev.devflow.com")
                .description("Servidor Desenvolvimento");

        Contact contact = new Contact()
                .name("Professor Jucelio Farias Coelho")
                .email("contato@devflow.com")
                .url("https://github.com/");

        License license = new License()
                .name("MIT License")
                .url("https://opensource.org/licenses/MIT");

        Info info = new Info()
                .title("DevFlow Pay API")
                .version("1.0.0")
                .description("""
                        API REST desenvolvida para fins educacionais.

                        Recursos:
                        • Autenticação JWT
                        • Gestão de Usuários
                        • Produtos
                        • Pedidos
                        • Pagamentos
                        • Webhooks
                        • AWS Lambda (Simulada)
                        """)
                .contact(contact)
                .license(license);

        return new OpenAPI()
                .info(info)
                .servers(List.of(localServer, devServer))
                .externalDocs(
                        new ExternalDocumentation()
                                .description("Documentação do Projeto")
                                .url("https://github.com/")
                );
    }
}