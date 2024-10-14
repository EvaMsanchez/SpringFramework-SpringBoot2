package com.eva.springboot.di.app.springboot_di.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.eva.springboot.di.app.springboot_di.models.Product;
import com.eva.springboot.di.app.springboot_di.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api")
public class SomeController 
{
    // Inyectar una instancia, pero en vez de una concreta como ProductServiceImpl, inyectando mediante la interfaz
    @Autowired // inyección mediante el atributo
    private ProductService service;


    @GetMapping
    public List<Product> list()
    {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Product show(@PathVariable Long id)
    {
        return service.findById(id);
    }
}
