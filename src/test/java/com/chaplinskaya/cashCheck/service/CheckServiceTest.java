package com.chaplinskaya.cashCheck.service;

import com.chaplinskaya.cashCheck.dto.ProductDto;
import com.chaplinskaya.cashCheck.dto.request.ProductsDTO;
import com.chaplinskaya.cashCheck.dto.request.ProductsItem;
import com.chaplinskaya.cashCheck.model.entity.Check;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class CheckServiceTest {

    private Check check;
    private List<ProductDto> productDtoTest;
    private List<Integer> ids;
    @Autowired
    private CheckService checkService;
    private ProductsDTO request;
    private List<ProductsItem> items;

    @BeforeEach
    public void before() {

        this.productDtoTest = new ArrayList<>();
        productDtoTest.add(new ProductDto(1, "item1", 1, 10.00, false, 10.00));
        productDtoTest.add(new ProductDto(2, "item2", 5, 10.80, true, 54.00));

        this.ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);

        this.items = new ArrayList<>();
        items.add(new ProductsItem(1, 1));
        items.add(new ProductsItem(5, 2));

        this.request = ProductsDTO.builder()
                .products(items)
                .discountCard("card-111")
                .build();

        this.check = Check.builder()
                .productDtos(productDtoTest)
                .discountCard("card-111")
                .sum(64.00)
                .sumWithDiscount(62.08)
                .build();
    }

    @Test
    void addProductTest() {

        Assert.assertEquals(check, checkService.addProducts(ids, request));
    }

    @Test
    void getCheckTest() {
        Assert.assertEquals(check, checkService.getCheck(request));
    }
}
