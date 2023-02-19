package com.ngsystem.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean("employeeMapper")
    public ModelMapper employeeMapper() {
        return new ModelMapper();
    }
}
