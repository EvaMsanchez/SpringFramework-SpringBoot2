package com.eva.springboot.di.app.springboot_di.repositories;

import java.util.List;
import java.io.IOException;
import java.util.Arrays;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.eva.springboot.di.app.springboot_di.models.Product;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ProductRepositoryJson implements ProductRepository
{
    private List<Product> list;

    // Constructor vacío
    public ProductRepositoryJson()
    {
        // Leer un archivo, primero seleccionamos donde se encuentra
        Resource resource = new ClassPathResource("json/product.json");
        // Convertir un archivo a un objeto de java
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Lee el archivo y luego lo puebla en el objeto Product
            list = Arrays.asList(objectMapper.readValue(resource.getFile(), Product[].class));
        } catch (StreamReadException e) {
            e.printStackTrace();
        } catch (DatabindException e) {
            e.printStackTrace();
        } catch (IOException e) { 
            e.printStackTrace();
        }
    }


    @Override
    public List<Product> findAll() 
    {
        return list;
    }

    @Override
    public Product findById(Long id) 
    {
        // Si no lo encuentra devuelve una excepción
        return list.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow();
    }

}
