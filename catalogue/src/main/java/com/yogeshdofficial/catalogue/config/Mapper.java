package com.yogeshdofficial.catalogue.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Mapper {
  ModelMapper modelMapper;

  @Bean
  ModelMapper getModelMapper() {
    return new ModelMapper();
  }
}
