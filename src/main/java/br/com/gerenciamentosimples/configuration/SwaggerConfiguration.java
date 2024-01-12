package br.com.gerenciamentosimples.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI openApi() {
        return new OpenAPI()
        .info(info()
        .contact(contact()));
    }

    private Info info() {
        return new Info()
        .title("GerenciamentoSimples")
        .description("API para Gerenciamento de Entradas e Saídas")
        .version("1.0.0");
    }

    private Contact contact() {
        return new Contact()
        .name("Jonathan Zapotosczny | Karoline Goergen")
        .email("JonathanGM.HD@gmail.com")
        .url("https://github.com/JonathanZapotosczny/GerenciamentoSimples");
    }
}