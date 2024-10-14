package com.eva.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import com.eva.springboot.di.app.springboot_di.models.Product;
import com.eva.springboot.di.app.springboot_di.repositories.ProductRepositoryImpl;


// Obtiene los datos del repositorio y puede trabajar con ellos (cálculos), interactuar con otro repositorio, combinar repositorios
public class ProductServiceImpl implements ProductService
{
    // Comunicarnos
    private ProductRepositoryImpl repository = new ProductRepositoryImpl();


    @Override
    public List<Product> findAll()
    {
        return repository.findAll().stream().map(p -> {
            Double priceImp = p.getPrice() * 1.25d;
            
            // Product newProd = new Product(p.getId(), p.getName(), priceTax.longValue());
            // Creamos una nueva instancia de producto pero con los datos clonados del original, como devuelve un tipo "Object" hacemos un casting para obtener el tipo original "Product"
            Product newProd = (Product) p.clone(); 
            newProd.setPrice(priceImp.longValue());
            return newProd;
        }).collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id)
    {
        return repository.findById(id);
    }
}
