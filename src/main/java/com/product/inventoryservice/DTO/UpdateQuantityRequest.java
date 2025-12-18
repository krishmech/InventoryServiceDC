package com.product.inventoryservice.DTO;

import lombok.Data;

@Data
public class UpdateQuantityRequest {
    private String productId;
    private Long quantity;
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
}
