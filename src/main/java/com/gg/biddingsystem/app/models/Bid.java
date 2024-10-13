package com.gg.biddingsystem.app.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
public class Bid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private AppUser bidder;

    private Double bidAmount;
    private LocalDateTime bidTime;

    // Additional fields for relationships and auditing
}
