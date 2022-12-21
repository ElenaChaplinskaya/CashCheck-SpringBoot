package com.chaplinskaya.cashCheck.service.impl;

import com.chaplinskaya.cashCheck.dto.ProductDto;
import com.chaplinskaya.cashCheck.dto.request.ProductsDTO;
import com.chaplinskaya.cashCheck.model.entity.Check;
import com.chaplinskaya.cashCheck.service.CheckService;
import com.chaplinskaya.cashCheck.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CheckServiceImpl implements CheckService {
    private final ProductService productService;

    @Override
    public Check addProducts(List<Integer> productIds, ProductsDTO productsDTO) {
        Check check = new Check();
        List<ProductDto> productDtos = productService.toDto(productService.createListOfProducts(productIds), productsDTO);
        check.setProductDtos(productDtos);
        check.setDiscountCard(productsDTO.getDiscountCard());
        check.setSum(productService.countSum(productIds, productsDTO));
        check.setSumWithDiscount(productService.countSumWithDiscount(productIds, productsDTO));
        return check;
    }

    @Override
    public Check getCheck(ProductsDTO productsDTO) {
        return addProducts(productService.getIdsProducts(productsDTO), productsDTO);
    }
}
