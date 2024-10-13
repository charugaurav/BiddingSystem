package com.gg.biddingsystem.app.service;

import com.gg.biddingsystem.app.models.Bid;
import com.gg.biddingsystem.app.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public interface BidService {
    Bid placeBid(Bid bid);
    Optional<Bid> getHighestBidForProduct(Long productId);

    List<Bid> getBidsForProduct(Product product);
}

