package Service;

import models.Bid;

import java.util.Optional;

public interface BidService {
    Bid placeBid(Long productId, Long userId, Double bidAmount);
    Optional<Bid> getHighestBidForProduct(Long productId);
}

