package com.chaplinskaya.cashCheck.service.impl;

import com.chaplinskaya.cashCheck.dto.DiscountCardDto;
import com.chaplinskaya.cashCheck.model.entity.DiscountCard;
import com.chaplinskaya.cashCheck.model.repository.DiscountCardRepository;
import com.chaplinskaya.cashCheck.service.DiscountCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DiscountCardServiceImpl implements DiscountCardService {

    private final DiscountCardRepository discountCardRepository;

    @Override
    public DiscountCardDto findByNumber(String number) {
        try {
            toDto(discountCardRepository.findByNumber(number));
        } catch (Exception ex){
            ex.printStackTrace();
            System.out.println("Card number not found");
        }
        return toDto(discountCardRepository.findByNumber(number));
    }

    @Override
    public DiscountCardDto toDto(DiscountCard discountCard) {

        return DiscountCardDto.builder()
                .name(discountCard.getNumber())
                .discount(discountCard.getDiscount())
                .build();
    }
}
