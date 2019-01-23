package com.order.controller;

import com.order.Model.Order;
import com.order.Model.Product;
import com.order.Repository.ProductRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductRESTController {

    private ProductRepository productRepository;
    public ProductRESTController(ProductRepository productRepository) {
        this.productRepository=productRepository;
    }

    @RequestMapping(
            value = "/product/create",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public void create(@RequestBody Product product){
        productRepository.save(product);
    }
    @RequestMapping(
            value="/product/{id}/delete",
            method = RequestMethod.PUT ,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )

    public void delete(@PathVariable Long id){
        productRepository.delete(id);
    }

    @RequestMapping(
            value="/product/edit",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )

    public void edit(@RequestBody Product product){
        productRepository.save(product);
    }

    @RequestMapping(
            value="/product/getAll",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )

    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }
}
