package com.project.microservice.loans.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoanConfig {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
