package com.eva.springboot.di.app.springboot_di.services;

import java.util.List;

import com.eva.springboot.di.app.springboot_di.models.Product;

// Interfaz le dice a las clases que la implementan, que métodos tienen que implementar, obliga a implementar todos los métodos que estén en la interface
public interface ProductService 
{
    // Contratos: son los nombres de los métodos que tiene que implementar 
    List<Product> findAll();
    
    Product findById(Long id);
}
