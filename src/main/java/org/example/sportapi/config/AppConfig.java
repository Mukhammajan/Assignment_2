package org.example.sportapi.config;

import org.example.sportapi.repository.SportDAO;
import org.example.sportapi.repository.SportRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public SportRepository sportRepository() {
        return new SportDAO();
    }
}

