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
    @GetMapping("/expensive")
    public ResponseEntity<?> getExpensiveProducts() {
        return ResponseEntity.ok(productServise.getExpensiveProducts());
    }
    @GetMapping("/count")
    public ResponseEntity<?> getProductCount() {
        return ResponseEntity.ok(productServise.getProductCount());
    }
    @PutMapping("/discount")
    public ResponseEntity<?> discountProducts() {
        productServise.discountAllProducts();
        return ResponseEntity.ok(new ApiResponse("All products discounted by 10%"));
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<?> getProductsByCategory(@PathVariable String categoryId) {
        return ResponseEntity.ok(productServise.getProductsByCategory(categoryId));
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<?> searchProductsByName(@PathVariable String name) {
        return ResponseEntity.ok(productServise.searchProductsByName(name));
    }









}
