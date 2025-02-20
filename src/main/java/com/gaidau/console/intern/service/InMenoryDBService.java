package com.gaidau.console.intern.service;

import com.gaidau.console.intern.domain.dto.ProductsDTO;
import org.springframework.stereotype.Service;

@Service
public class InMenoryDBService {

    private ProductsDTO productsDTO;

    public ProductsDTO getProductsDTO() {
        return productsDTO;
    }

    public void setProductsDTO(ProductsDTO productsDTO) {
        this.productsDTO = productsDTO;
    }
}
