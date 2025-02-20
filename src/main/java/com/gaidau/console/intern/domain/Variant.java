package com.gaidau.console.intern.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
public class Variant {

    @Id
    private String id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties(value = {"variants"}, allowSetters = true)
    @JoinColumn(name = "product", nullable = false)
    private Product product;

    private String title;

    private String sku;

    private String barcode;

    private BigDecimal price;

    private BigDecimal compareAtPrice;

    @OneToMany(mappedBy = "variant")
    @JsonIgnoreProperties(value = {"variant"}, allowSetters = true)
    private List<InventoryItem> items;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getCompareAtPrice() {
        return compareAtPrice;
    }

    public void setCompareAtPrice(BigDecimal compareAtPrice) {
        this.compareAtPrice = compareAtPrice;
    }

    public List<InventoryItem> getItems() {
        return items;
    }

    public void setItems(List<InventoryItem> items) {
        this.items = items;
    }
}
