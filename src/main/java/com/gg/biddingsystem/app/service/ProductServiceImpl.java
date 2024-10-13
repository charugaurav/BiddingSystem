package com.gg.biddingsystem.app.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import com.gg.biddingsystem.app.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gg.biddingsystem.app.repository.ProductRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private final ProductRepository productRepository;

//    @Autowired
//    public ProductServiceImpl(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }

    @Override
    public Product createProduct(Product product) {
        if (product.getStartTime().isAfter(product.getEndTime())) {
            throw new IllegalArgumentException("Start time must be before end time");
        }
        return productRepository.save(product);
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    @Override
    public Optional<Product> getProductById(Long productId) {
        return productRepository.findById(productId);
    }

    @Override
    public boolean isBiddingOpen(Product product) {
        LocalDateTime now = LocalDateTime.now();
        return now.isAfter(product.getStartTime()) && now.isBefore(product.getEndTime());
    }
}

