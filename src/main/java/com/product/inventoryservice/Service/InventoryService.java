package com.product.inventoryservice.Service;

import com.product.inventoryservice.DTO.AddProductRequest;
import com.product.inventoryservice.Model.InventoryItem;
import com.product.inventoryservice.Repository.InventoryRepo;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service
@Transactional
public class InventoryService {

    @Autowired
    private InventoryRepo inventoryRepo;

    public String addInventory(AddProductRequest item) {
        String productId = generateProductId();
        InventoryItem inventoryItem = new InventoryItem();
        inventoryItem.setProductId(productId);
        inventoryItem.setProductName(item.getProductName());
        inventoryItem.setQuantity(item.getQuantity());
        inventoryItem.setPrice(item.getPrice());
        inventoryItem.setProductDescription(item.getProductDescription());
        inventoryItem.setProductCategory(item.getProductCategory());
        inventoryItem.setProductManufacturer(item.getProductManufacturer());
        inventoryItem.setProductSupplier(item.getProductSupplier());
        inventoryItem.setCreatedAt(LocalDateTime.now());
        inventoryItem.setUpdatedAt(LocalDateTime.now());
        inventoryRepo.save(inventoryItem);
        return "Inventory item added successfully" + productId;
    }

    public String updateInventory(String productId, Long quantity) {
        InventoryItem item = inventoryRepo.findByProductId(productId);
        if (item != null && item.getQuantity() >= quantity) {
            item.setQuantity(item.getQuantity() - quantity);
            item.setUpdatedAt(LocalDateTime.now());
            inventoryRepo.save(item);
            return "Inventory item updated successfully";
        } else if (item.getQuantity() == 0) {
            return "Out of stock";
        }
        else {
            return "Insufficient inventory or item not found";
        }
    }


    private String generateProductId() {
        return "PROD-" + System.currentTimeMillis();
    }

}
