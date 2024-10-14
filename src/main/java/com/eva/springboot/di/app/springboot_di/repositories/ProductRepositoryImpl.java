package com.eva.springboot.di.app.springboot_di.repositories;

import java.util.Arrays;
import java.util.List;

import com.eva.springboot.di.app.springboot_di.models.Product;


// Simulación de base de datos, aquí se leen los datos, guardamos los datos
// Implements: obliga a implementar todos los métodos de esa interface
public class ProductRepositoryImpl implements ProductRepository
{
    private List<Product> data;

    public ProductRepositoryImpl() 
    {
        this.data = Arrays.asList(
            new Product(1L, "Memoria corsair 32", 300L),
            new Product(2L, "CPU Interl Core 19", 850L),
            new Product(3L, "Teclado Razer Mini 60%", 180L),
            new Product(4L, "Motherboard Gigabyte", 490L)
        );
    }


    @Override
    public List<Product> findAll()
    {
        return data;
    }

    @Override
    public Product findById(Long id)
    {
        // Devuelve el producto si lo encuentra y sino null
        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }
}
