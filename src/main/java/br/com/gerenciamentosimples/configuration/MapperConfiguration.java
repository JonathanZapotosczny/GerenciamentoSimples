package br.com.gerenciamentosimples.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfiguration {

    @Bean
    public ModelMapper modelMapperConfig() {
        return new ModelMapper();
    }
}