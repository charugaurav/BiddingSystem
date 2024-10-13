package com.gg.biddingsystem.app.service;

import com.gg.biddingsystem.app.models.AppUser;
import com.gg.biddingsystem.app.repository.UserRepository;
import lombok.Data;
import com.gg.biddingsystem.app.models.Bid;
import com.gg.biddingsystem.app.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import com.gg.biddingsystem.app.repository.BidRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Data
public class BidServiceImpl implements BidService {
    @Autowired
    private final BidRepository bidRepository;
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final ProductService productService;

    @Override
    public Bid placeBid(Bid bid) {
        if (!productService.isBiddingOpen(bid.getProduct())) {
            throw new IllegalStateException("Bidding is closed for this product");
        }
        if (bid.getBidAmount() < bid.getProduct().getBasePrice()) {
            throw new IllegalArgumentException("Bid amount must be at least the base price");
        }

        return bidRepository.save(bid);
    }

    @Override
    public Optional<Bid> getHighestBidForProduct(Long productId) {
        return bidRepository.findTopByProductIdOrderByBidAmountDesc(productId);
    }

    @Override
    public List<Bid> getBidsForProduct(Product product) {
        return bidRepository.findByProduct(product);
    }
}

