package com.chaplinskaya.cashCheck.service;

import com.chaplinskaya.cashCheck.dto.DiscountCardDto;
import com.chaplinskaya.cashCheck.model.entity.DiscountCard;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DiscountCardServiceTest {

    private DiscountCard discountCard;
    private DiscountCardDto discountCardDto;
    @Autowired
    private DiscountCardService discountCardService;


    @BeforeEach
    public void before() {

        this.discountCard = DiscountCard.builder()
                .number("card-111")
                .discount(3)
                .build();

        this.discountCardDto = DiscountCardDto.builder()
                .name("card-111")
                .discount(3)
                .build();

    }
    @Test
    void toDtoTest() {
        Assert.assertEquals(discountCardDto, discountCardService.toDto(discountCard));
    }
    @Test
    void findByNumberTest() {
        String number = "card-111";
        Assert.assertEquals(discountCardDto, discountCardService.findByNumber(number));
    }
}
