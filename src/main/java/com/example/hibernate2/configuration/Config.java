package com.example.hibernate2.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Podvorchan Ruslan 11.02.2023
 */
@Configuration
public class Config {

  @Bean
  ObjectMapper objectMapper() {
    return new ObjectMapper();
  }

}
