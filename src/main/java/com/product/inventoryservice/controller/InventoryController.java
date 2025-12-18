package com.product.inventoryservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.inventoryservice.DTO.AddProductRequest;
import com.product.inventoryservice.DTO.UpdateQuantityRequest;
import com.product.inventoryservice.Service.InventoryService;

@RestController
@RequestMapping("/api/inventory/")

public class InventoryController {

	@Autowired
	private InventoryService inventoryService;
	
	@PostMapping("/addProduct")
	public ResponseEntity<String> addInventory(@RequestBody AddProductRequest item) {
		return ResponseEntity.ok(inventoryService.addInventory(item));
	}

	@PostMapping("/updateQuantity")
	public ResponseEntity<String> updateInventory(@RequestBody UpdateQuantityRequest request) {
		return ResponseEntity.ok(inventoryService.updateInventory(request.getProductId(), request.getQuantity()));
	}
	
	@GetMapping("/getAllProducts")
	public String getAllProducts() {
		return "All Products";
	}
	

}
