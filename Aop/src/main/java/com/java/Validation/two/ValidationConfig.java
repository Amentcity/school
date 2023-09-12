package com.java.Validation.two;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
@ComponentScan("com.java.Validation")
public class ValidationConfig {
    @Bean
    public LocalValidatorFactoryBean validation(){
        return new LocalValidatorFactoryBean();
    }
}
