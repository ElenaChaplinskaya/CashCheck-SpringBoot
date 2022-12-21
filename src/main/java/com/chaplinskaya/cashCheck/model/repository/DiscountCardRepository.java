package com.chaplinskaya.cashCheck.model.repository;

import com.chaplinskaya.cashCheck.model.entity.DiscountCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountCardRepository extends JpaRepository<DiscountCard,Integer> {

    DiscountCard findByNumber(String number);
}
