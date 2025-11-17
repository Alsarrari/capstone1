package com.springbooteventsystem.capstone1.Controller;

import com.springbooteventsystem.capstone1.ApiResponse.ApiResponse;
import com.springbooteventsystem.capstone1.Model.MerchantStock;
import com.springbooteventsystem.capstone1.Servise.MerchantStockServise;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/stock")
public class MerchantStockController {

    private final MerchantStockServise stockService;


    @GetMapping("/get")
    public ResponseEntity<?> getAllStocks() {
        return ResponseEntity.ok(stockService.getAll());
    }


    @PostMapping("/add")
    public ResponseEntity<?> addStock(@Valid @RequestBody MerchantStock merchantStock) {
        stockService.addStock(merchantStock);
        return ResponseEntity.status(200).body(new ApiResponse("Stock added successfully"));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateStock(@PathVariable String id,
                                         @Valid @RequestBody MerchantStock merchantStock) {

        boolean updated = stockService.updateStock(id, merchantStock);

        if (updated)
            return ResponseEntity.ok(new ApiResponse("Stock updated successfully"));

        return ResponseEntity.status(400).body(new ApiResponse("Stock not found"));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStock(@PathVariable String id) {

        boolean deleted = stockService.deleteStock(id);

        if (deleted)
            return ResponseEntity.ok(new ApiResponse("Stock deleted successfully"));

        return ResponseEntity.status(400).body(new ApiResponse("Stock not found"));
    }


    @PutMapping("/add-amount/{productId}/{merchantId}/{amount}")
    public ResponseEntity<?> addAmount(@PathVariable String productId,
                                       @PathVariable String merchantId,
                                       @PathVariable int amount) {

        boolean added = stockService.addAmount(productId, merchantId, amount);

        if (added)
            return ResponseEntity.ok(new ApiResponse("Amount added successfully"));

        return ResponseEntity.status(400).body(new ApiResponse("Merchant or Product not found"));
    }

}
