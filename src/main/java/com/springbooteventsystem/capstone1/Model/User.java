package com.springbooteventsystem.capstone1.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {@NotEmpty(message = "the id must not be null ")
private String id;

    @NotEmpty(message = "the username not be null")
    @Size(min = 5, message = "have to be more then 5 length long")
    private String userName;

    @NotNull(message = "the password not be null")
    @Size(min = 6 , message = "have to be more then 6 length long")
    @Pattern(
            regexp = "^(?=.*[A-Za-z])(?=.*\\d).+$",
            message = "password must contain letters and digits"
    )
    private String password;

    @NotEmpty(message = "email cannot be null")
    @Email(message = "invalid email format")
    private String email;

    @NotEmpty(message = "role cannot be empty")
    @Pattern(
            regexp = "^(Admin|Customer)$",
            message = "role must be either Admin or Customer"
    )
    private String role;

    @NotNull(message = "balance cannot be null")
    @Positive(message = "balance must be positive")
    private Double balance;

}
