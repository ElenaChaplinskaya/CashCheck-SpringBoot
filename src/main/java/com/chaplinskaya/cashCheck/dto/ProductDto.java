package com.chaplinskaya.cashCheck.dto;

import com.chaplinskaya.cashCheck.model.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {

    private Integer id;
    private String name;
    private Integer quantity;
    private double price;
    private boolean discount;
    private double total;

    public ProductDto(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.quantity = getQuantity();
        this.price = product.getPrice();
        this.discount= product.isDiscount();
        this.total = getTotal();
    }
}
