package com.springbooteventsystem.capstone1.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MerchantStock {

    @NotNull(message = "id cannot be null")
    private String id;

    @NotNull(message = "merchantId cannot be null")
    private String merchantId;

    @NotNull(message = "productId cannot be null")
    private String productId;

    @Positive(message = "stock must be a positive number")
    private int stock;



}
