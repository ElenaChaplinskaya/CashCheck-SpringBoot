package com.chaplinskaya.cashCheck.model.entity;

import com.chaplinskaya.cashCheck.dto.DiscountCardDto;
import com.chaplinskaya.cashCheck.dto.ProductDto;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Check {
    private List<ProductDto> productDtos;
    private String discountCard;
    private double sum;
    private double sumWithDiscount;


}
