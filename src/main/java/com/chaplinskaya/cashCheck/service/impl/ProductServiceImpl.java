package com.chaplinskaya.cashCheck.service.impl;

import com.chaplinskaya.cashCheck.dto.DiscountCardDto;
import com.chaplinskaya.cashCheck.dto.ProductDto;
import com.chaplinskaya.cashCheck.dto.request.ProductsDTO;
import com.chaplinskaya.cashCheck.dto.request.ProductsItem;
import com.chaplinskaya.cashCheck.model.repository.ProductRepository;
import com.chaplinskaya.cashCheck.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final DiscountCardServiceImpl discountCardService;


    @Override
    @Transactional
    public List<ProductDto> createListOfProducts(List<Integer> productIds) {
        return productIds.stream()
                .map(productRepository::getById)
                .map(ProductDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> toDto(List<ProductDto> productsDtos, ProductsDTO productsDTO) {
        List<ProductDto> productDtos = new ArrayList<>();
        List<ProductsItem> items = productsDTO.getProducts();
        for (ProductDto p : productsDtos) {
            for (ProductsItem pi : items) {
                if (p.getId() == pi.getId()) {
                    p.setQuantity(pi.getCount());
                    p.setPrice(priceAccordingToQuantity(p));
                    p.setTotal(p.getQuantity() * p.getPrice());
                }
            }
        }
        return productsDtos;
    }

    @Override
    public double priceAccordingToQuantity(ProductDto productDto) {
        double newPrice = 0;
        if (productDto.isDiscount() == true && productDto.getQuantity() >= 5) {
            newPrice = productDto.getPrice() - (productDto.getPrice() * 10 / 100);
            return newPrice;
        } else {
            return productDto.getPrice();
        }
    }

    @Override
    @Transactional
    public double countSumWithDiscount(List<Integer> productIds, ProductsDTO productsDTO) {
        double sumWithDiscount = 0;
        String nameDiscountCard;
        double sumDiscount = 0;
        nameDiscountCard = productsDTO.getDiscountCard();
        DiscountCardDto discountCardDto = discountCardService.findByNumber(nameDiscountCard);
        sumDiscount = countSum(productIds, productsDTO) * discountCardDto.getDiscount() / 100;
        sumWithDiscount = countSum(productIds, productsDTO) - sumDiscount;

        return sumWithDiscount;
    }

    @Override
    @Transactional
    public double countSum(List<Integer> productIds, ProductsDTO productsDTO) {
        double sum = 0;
        List<ProductDto> productDtos = toDto(createListOfProducts(productIds), productsDTO);
        for (ProductDto p : productDtos) {
            sum += p.getTotal();
        }
        return sum;
    }

    @Override
    public List<Integer> getIdsProducts(ProductsDTO request) {
        return request.getProducts().stream().map(ProductsItem::getId).collect(Collectors.toList());
    }
}

