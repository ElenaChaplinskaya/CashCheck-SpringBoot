package com.chaplinskaya.cashCheck.service;

import com.chaplinskaya.cashCheck.dto.DiscountCardDto;
import com.chaplinskaya.cashCheck.model.entity.DiscountCard;

public interface DiscountCardService {

    DiscountCardDto findByNumber(String number);
    DiscountCardDto toDto(DiscountCard discountCard);
}
