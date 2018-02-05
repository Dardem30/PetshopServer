package com.petshop.petshop.security.config;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration for Dozer.
 */
@Configuration
public class DozerConfig {

    @Bean
    public DozerBeanMapper mapper() {

        return new DozerBeanMapper();
    }
}
