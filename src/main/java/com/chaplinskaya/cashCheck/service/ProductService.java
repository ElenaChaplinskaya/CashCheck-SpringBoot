package com.chaplinskaya.cashCheck.service;

import com.chaplinskaya.cashCheck.dto.ProductDto;
import com.chaplinskaya.cashCheck.dto.request.ProductsDTO;

import java.util.List;

public interface ProductService {
    List<ProductDto> createListOfProducts(List<Integer> productIds);

    List<ProductDto> toDto(List<ProductDto> productsDtos, ProductsDTO productsDTO);

    double priceAccordingToQuantity(ProductDto productDto);

    double countSumWithDiscount(List<Integer> productIds, ProductsDTO productsDTO);

    double countSum(List<Integer> productIds, ProductsDTO productsDTO);

    List<Integer> getIdsProducts(ProductsDTO request);

}
