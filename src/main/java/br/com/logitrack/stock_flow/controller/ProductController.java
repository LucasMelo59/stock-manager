package br.com.logitrack.stock_flow.controller;

import br.com.logitrack.stock_flow.form.ProductForm;
import br.com.logitrack.stock_flow.service.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    @RequestMapping("/register")
    public Long registerProduct(@RequestBody ProductForm form) {
        return service.createProduct(form);
    }

}
