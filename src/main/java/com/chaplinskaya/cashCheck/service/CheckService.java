package com.chaplinskaya.cashCheck.service;

import com.chaplinskaya.cashCheck.dto.request.ProductsDTO;
import com.chaplinskaya.cashCheck.model.entity.Check;

import java.util.List;

public interface CheckService {

    Check addProducts(List<Integer> productIds, ProductsDTO productsDTO);
    Check getCheck(ProductsDTO request);
}
