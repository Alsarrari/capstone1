package com.springbooteventsystem.capstone1.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Merchant {
    @NotEmpty(message = "the id  must not be empty")

    private String id;
    @NotEmpty(message = "The name must not be empty")
    @Size(min = 3 , message = "The name must be longer than 3")
    private String name;

}

