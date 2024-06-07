package com.project.microservice.members.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MemberConfig {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

}
