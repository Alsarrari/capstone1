package com.springbooteventsystem.capstone1.Controller;

import com.springbooteventsystem.capstone1.ApiResponse.ApiResponse;
import com.springbooteventsystem.capstone1.Model.Product;
import com.springbooteventsystem.capstone1.Servise.ProductServise;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController

@RequestMapping("/api/p1/product")
@RequiredArgsConstructor
public class ProductController {
    public final ProductServise productServise;

    @GetMapping("/get")
    public ResponseEntity<?> getAllProduct(){

        return ResponseEntity.status(200).body(productServise.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addProduct(@Valid  @RequestBody Product product , Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        productServise.products.add(product);
        return ResponseEntity.status(200).body("add product");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable String id) {
        boolean isDeleted = productServise.deleteProduct(id);

        if (isDeleted)
            return ResponseEntity.status(200).body(new ApiResponse("Product deleted successfully"));


        return ResponseEntity.status(400).body(new ApiResponse("Product not found"));
    }
        @PutMapping("/update/{id}")
    public ResponseEntity<?> updateProduct(@Valid @PathVariable String id ,@RequestBody Product product){
        boolean isupdate = productServise.updateProduct(id, product);
        if (isupdate)
            return ResponseEntity.status(200).body(new ApiResponse("product update"));
            return ResponseEntity.status(400).body(new ApiResponse("product not found"));

    }
    @GetMapping("/high-price")
    public ResponseEntity<?> getHighPriceProducts() {
        return ResponseEntity.status(200).body(productServise.getHighPriceProducts());
    }
    @GetMapping("/count")
    public ResponseEntity<?> getProductCount() {
        return ResponseEntity.status(200).body(productServise.getProductCount());
    }
    @PutMapping("/discount/{id}")
    public ResponseEntity<?> applyDiscount(@PathVariable String id) {
        boolean done = productServise.applyDiscount(id);

        if (done)
            return ResponseEntity.status(200).body(new ApiResponse("Discount applied"));

        return ResponseEntity.status(400).body(new ApiResponse("Product not found"));
    }







}
