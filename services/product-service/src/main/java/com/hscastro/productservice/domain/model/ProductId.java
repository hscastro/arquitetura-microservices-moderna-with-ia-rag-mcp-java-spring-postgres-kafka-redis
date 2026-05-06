package com.hscastro.productservice.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.springframework.util.Assert;

import java.util.UUID;

@Embeddable
public record ProductId(
        @Column(name = "id", nullable = false)
        UUID id)
{ }
