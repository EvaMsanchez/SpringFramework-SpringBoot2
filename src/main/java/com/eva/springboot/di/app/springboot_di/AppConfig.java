package com.eva.springboot.di.app.springboot_di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.eva.springboot.di.app.springboot_di.repositories.ProductRepository;
import com.eva.springboot.di.app.springboot_di.repositories.ProductRepositoryJson;

@Configuration
@PropertySource("classpath:config.properties")
public class AppConfig 
{
    // Bean: para crear registrar un componente spring pero no desde la propia clase, sino desde otra la configuramos
    @Bean("productJson")
    ProductRepository productRepositoryJson()
    {
        // Crean una instancia de una clase creada por nosotros o puede ser una librería, una API
        return new ProductRepositoryJson();
    }
}
