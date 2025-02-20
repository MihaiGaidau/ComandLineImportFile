package com.gaidau.console.intern.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
public class ProductTag {

    @Id
    private String id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties(value = { "productTags"}, allowSetters = true)
    @JoinColumn(name = "product", nullable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties(value = { "productTags"}, allowSetters = true)
    @JoinColumn(name = "tag", nullable = false)
    private Tag tag;

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

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }
}
