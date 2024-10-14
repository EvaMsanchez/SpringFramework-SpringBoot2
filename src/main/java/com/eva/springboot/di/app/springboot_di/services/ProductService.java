package com.eva.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import com.eva.springboot.di.app.springboot_di.models.Product;
import com.eva.springboot.di.app.springboot_di.repositories.ProductRepository;


// Obtiene los datos del repositorio y puede trabajar con ellos (cálculos), interactuar con otro repositorio, combinar repositorios
public class ProductService 
{
    // Comunicarnos
    private ProductRepository repository = new ProductRepository();


    public List<Product> findAll()
    {
        return repository.findall().stream().map(p -> {
            Double priceImp = p.getPrice() * 1.25d;
            p.setPrice(priceImp.longValue());
            return p;
        }).collect(Collectors.toList());
    }

    public Product findById(Long id)
    {
        return repository.findById(id);
    }
}
