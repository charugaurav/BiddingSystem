package Service;

import lombok.Data;
import models.Bid;
import models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import repository.BidRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Data
public class BidServiceImpl implements BidService {
    @Autowired
    private final BidRepository bidRepository;
    @Autowired
    private final ProductService productService;

    @Override
    public Bid placeBid(Long productId, Long userId, Double bidAmount) {
        Product product = productService.getProductById(productId)
                .orElseThrow(() -> new NoSuchElementException("Product not found"));
        if (!productService.isBiddingOpen(product)) {
            throw new IllegalStateException("Bidding is closed for this product");
        }
        if (bidAmount < product.getBasePrice()) {
            throw new IllegalArgumentException("Bid amount must be at least the base price");
        }

        // Create and save new bid
        Bid bid = new Bid(product, bidAmount, LocalDateTime.now());
        return bidRepository.save(bid);
    }

    @Override
    public Optional<Bid> getHighestBidForProduct(Long productId) {
        return bidRepository.findTopByProductIdOrderByBidAmountDesc(productId);
    }
}

