package com.gg.biddingsystem.app.controller;

import com.gg.biddingsystem.app.models.Bid;
import com.gg.biddingsystem.app.models.BidBuilder;
import com.gg.biddingsystem.app.models.Product;
import com.gg.biddingsystem.app.service.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bids")
public class BidController {

    @Autowired
    private BidService bidService;

    // Create a new bid
    @PostMapping
    public ResponseEntity<Bid> createBid(@RequestBody Bid bid) {
        Bid createdBid = bidService.placeBid(bid);
        return ResponseEntity.ok(createdBid);
    }

    // Get all bids for a specific product
    @GetMapping("/product/{productId}")
    public ResponseEntity<List<Bid>> getBidsForProduct(@PathVariable Product product) {
        List<Bid> bids = bidService.getBidsForProduct(product);
        return ResponseEntity.ok(bids);
    }
}

