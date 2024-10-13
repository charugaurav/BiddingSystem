package com.gg.biddingsystem.app.repository;

import com.gg.biddingsystem.app.models.Bid;
import com.gg.biddingsystem.app.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BidRepository extends JpaRepository<Bid, Long> {
    Optional<Bid> findTopByProductIdOrderByBidAmountDesc(Long productId);

    List<Bid> findByProduct(Product product);
}
