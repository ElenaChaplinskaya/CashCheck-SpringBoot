package com.chaplinskaya.cashCheck.dto.request;

import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class ProductsDTO {
	private String discountCard;
	private List<ProductsItem> products;
}