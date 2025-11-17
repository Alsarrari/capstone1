package com.springbooteventsystem.capstone1.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Category {
    @NotEmpty(message = "the id not be empoty")

    private String id ;
    @NotEmpty(message = "name cannot be null")
    @Size(min = 3,message = "name must be more than 3 characters")
    private String name;
}
