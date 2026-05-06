package com.hscastro.productservice.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {

    @EmbeddedId
    private ProductId id;
    private String name;
    private String description;
    private BigDecimal price;

}
