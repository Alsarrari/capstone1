package com.springbooteventsystem.capstone1.Model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MerchantStock {
    @NotEmpty(message = "the id cannot null")
    private String id ;
    @NotEmpty(message = "the product cannot null")
    private String product;
    @NotEmpty(message = "the merchantid must not be empty")
    private String merchantid;
    @NotNull(message = "the stock must be null")
    @Min(value = 10,message = "have to be more then 10 at start")
    private int stock;


}
