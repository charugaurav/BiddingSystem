package Service;

import models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product createProduct(Product product);
    List<Product> getProductsByCategory(String category);
    Optional<Product> getProductById(Long productId);
    boolean isBiddingOpen(Product product);

}

