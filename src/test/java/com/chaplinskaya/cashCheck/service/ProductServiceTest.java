package com.chaplinskaya.cashCheck.service;

import com.chaplinskaya.cashCheck.dto.ProductDto;
import com.chaplinskaya.cashCheck.dto.request.ProductsDTO;
import com.chaplinskaya.cashCheck.dto.request.ProductsItem;
import com.chaplinskaya.cashCheck.model.entity.Product;
import com.chaplinskaya.cashCheck.model.repository.DiscountCardRepository;
import com.chaplinskaya.cashCheck.model.repository.ProductRepository;
import org.hibernate.Session;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
public class ProductServiceTest {

    private ProductRepository productRepository;
    @Autowired
    private ProductService productService;
    private List<Integer> ids;
    private List<ProductDto> productDtoTest;
    private List<ProductDto> productDtoTest1;
    private ProductsDTO request;
    private List<ProductsItem> items;
    private List<Product> products;
    @Autowired
    private DiscountCardRepository discountCardRepository;

    @BeforeEach
    public void before() {

        this.ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);

        this.productDtoTest = new ArrayList<>();
        productDtoTest.add(new ProductDto(1, "item1", 1, 5.00, false, 5.00));
        productDtoTest.add(new ProductDto(2, "item2", 5, 0.90, true, 4.50));

        this.productDtoTest1 = new ArrayList<>();
        productDtoTest1.add(new ProductDto(1, "item1", null, 10.00, false, 0.00));
        productDtoTest1.add(new ProductDto(2, "item2", null, 12.00, true, 0.00));


        this.items = new ArrayList<>();
        items.add(new ProductsItem(1, 1));
        items.add(new ProductsItem(5, 2));

        this.request = ProductsDTO.builder()
                .products(items)
                .discountCard("card-111")
                .build();

        this.products = new ArrayList<>();
        products.add(new Product(1, "item1", 10.00, false));
        products.add(new Product(2, "item2", 12.00, true));

    }

    @Test
    void getIdsProductsTest() {

        List<Integer> expectedList = productService.getIdsProducts(request);
        List<Integer> actualList = ids;
        Assert.assertEquals(expectedList, actualList);
    }

    @Test
    void createListOfProductsTest() {
        List<ProductDto> actualList = productDtoTest1;
        List<ProductDto> expectedList = productService.createListOfProducts(ids);

        Assert.assertEquals(expectedList, actualList);

    }

    @Test
    void priceAccordingToQuantityTest() {
        ProductDto productDto = ProductDto.builder()
                .price(1.00)
                .quantity(5)
                .discount(true)
                .build();
        Assert.assertEquals(0.90, productService.priceAccordingToQuantity(productDto), 0);
    }

    @Test
    void toDtoTest() {

        Assert.assertEquals(productDtoTest, productService.toDto(productDtoTest, request));
    }

    @Test
    void countSumTest() {
        double actualSum = 64.00;
        Assert.assertEquals(actualSum, productService.countSum(ids, request), 0);

    }

    @Test
    void countSumWithDiscountTest() {
        double sumWithdiscount = 62.08;

        Assert.assertEquals(sumWithdiscount, productService.countSumWithDiscount(ids, request),0);

    }

}
