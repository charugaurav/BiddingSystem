package com.gg.biddingsystem.app.models;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BidBuilder {
    private Product product;
    private AppUser bidder;
    private Double bidAmount;
    private LocalDateTime bidTime;

    public BidBuilder() {
        this.bidTime = LocalDateTime.now(); // Default to current time if not provided
    }

    public Bid build() {
        if (this.product == null) {
            throw new IllegalStateException("Product cannot be null");
        }
        if (this.bidder == null) {
            throw new IllegalStateException("Bidder cannot be null");
        }
        if (this.bidAmount == null || this.bidAmount <= 0) {
            throw new IllegalStateException("Bid amount must be positive");
        }

        Bid bidObj = new Bid();
        bidObj.setProduct(product);
        bidObj.setBidder(bidder);
        bidObj.setBidAmount(bidAmount);
        bidObj.setBidTime(bidTime);
        return bidObj;
    }
}
