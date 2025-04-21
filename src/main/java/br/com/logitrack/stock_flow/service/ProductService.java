package br.com.logitrack.stock_flow.service;

import br.com.logitrack.stock_flow.entity.Product;
import br.com.logitrack.stock_flow.entity.ProductCategory;
import br.com.logitrack.stock_flow.form.ProductForm;
import br.com.logitrack.stock_flow.repository.ProductCategoryRepository;
import br.com.logitrack.stock_flow.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    private final ProductCategoryRepository productCategoryRepository;

    public ProductService(ProductRepository productRepository, ProductCategoryRepository productCategoryRepository) {
        this.productRepository = productRepository;
        this.productCategoryRepository = productCategoryRepository;
    }

    @Transactional
    public Long createProduct(ProductForm form) {

        Product product = form.toEntity(productCategoryRepository.findById(Long.valueOf(1)).get());

        return  productRepository.save(product).getId();
    }


}
