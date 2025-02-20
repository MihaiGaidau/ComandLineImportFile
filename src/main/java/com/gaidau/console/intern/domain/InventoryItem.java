package com.gaidau.console.intern.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
public class InventoryItem {

    @Id
    private String id;


    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties(value = { "items"}, allowSetters = true)
    @JoinColumn(name = "variant", nullable = false)
    private Variant variant;

    private String sku;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Variant getVariant() {
        return variant;
    }

    public void setVariant(Variant variant) {
        this.variant = variant;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }
}
