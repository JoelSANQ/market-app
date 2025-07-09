package com.tecdesoftware.market.web.controller;

import com.tecdesoftware.market.domain.Product;
import com.tecdesoftware.market.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// Le dice a Spring que esta clase expone una API REST
@RestController
@RequestMapping("/products") // URL base: http://localhost:8080/products
public class ProductController {

    @Autowired
    private ProductService productService;

    // GET /products/all
    // Devuelve todos los productos
    @GetMapping("/all")
    public List<Product> getAll(){
        return productService.getAll();
    }

    // GET /products/{id}
    // Devuelve un producto por su id
    @GetMapping("/{id}")
    public Optional<Product> getProduct(@PathVariable("id") int productId){
        return productService.getProduct(productId);
    }

    // GET /products/category/{categoryId}
    // Devuelve los productos de una categoría específica
    @GetMapping("/category/{categoryId}")
    public Optional<List<Product>> getByCategory(@PathVariable("categoryId") int categoryId){
        return productService.getByCategory(categoryId);
    }

    // POST /products
    // Guarda un nuevo producto
    @PostMapping
    public Product save(@RequestBody Product product){
        return productService.save(product);
    }

    // DELETE /products/{id}
    // Elimina un producto por su id
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int productId){
        return productService.delete(productId);
    }
}
