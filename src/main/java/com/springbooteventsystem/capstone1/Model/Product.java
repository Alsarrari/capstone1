package com.springbooteventsystem.capstone1.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    @NotNull(message = "the id cannot nul")
    private String id;
    @NotNull(message = "the name cannot null")
    @Size(min = 3 , message = "The name must be longer than 3")
    private String name;
    @NotNull(message = "price cannot null")
    @Positive(message = "the number must be positive")
    private double price;
    @NotEmpty(message = "the category cannot must be empty ")
    private String categoryid;


}
