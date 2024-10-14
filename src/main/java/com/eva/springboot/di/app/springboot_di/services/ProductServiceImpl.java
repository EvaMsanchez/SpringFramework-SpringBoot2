package com.eva.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eva.springboot.di.app.springboot_di.models.Product;
import com.eva.springboot.di.app.springboot_di.repositories.ProductRepository;

// Obtiene los datos del repositorio y puede trabajar con ellos (cálculos), interactuar con otro repositorio, combinar repositorios
@Component // El contenedor crea la instancia, la guarda y se puede inyectar a otros componentes. Singleton: instancia única
public class ProductServiceImpl implements ProductService
{
    // Comunicarnos
    // private ProductRepositoryImpl repository = new ProductRepositoryImpl();

    // Ahora no se instancia el objeto, el contenedor nos llama y nos provee inyecta una instancia
    // Inyectar una instancia, pero en vez de una concreta como ProductRepositoryImpl, inyectando mediante la interfaz más genérica
    @Autowired
    private ProductRepository repository;


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
