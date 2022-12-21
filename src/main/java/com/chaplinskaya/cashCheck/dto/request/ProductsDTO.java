package com.chaplinskaya.cashCheck.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductsDTO {
	private String discountCard;
	private List<ProductsItem> products;
}