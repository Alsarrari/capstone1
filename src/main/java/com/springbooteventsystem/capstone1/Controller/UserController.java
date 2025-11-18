package com.springbooteventsystem.capstone1.Controller;

import com.springbooteventsystem.capstone1.ApiResponse.ApiResponse;
import com.springbooteventsystem.capstone1.Model.User;
import com.springbooteventsystem.capstone1.Servise.UserServise;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/u1/user")
public class UserController {


    private final UserServise userServise;

    @GetMapping("/get")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(userServise.getAllUser());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addUser(@Valid @RequestBody User user) {
        userServise.addUser(user);
        return ResponseEntity.ok(new ApiResponse("User added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateUser(@PathVariable String id,
                                        @Valid @RequestBody User user) {

        boolean updated = userServise.updateUser(id, user);

        if (updated)
            return ResponseEntity.ok(new ApiResponse("User updated"));

        return ResponseEntity.status(400).body(new ApiResponse("User not found"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable String id) {
        boolean deleted = userServise.deleteUser(id);

        if (deleted)
            return ResponseEntity.ok(new ApiResponse("User deleted"));

        return ResponseEntity.status(400).body(new ApiResponse("User not found"));
    }

    @PutMapping("/buy/{userId}/{productId}/{merchantId}")
    public ResponseEntity<?> buyProduct(@PathVariable String userId,
                                        @PathVariable String productId,
                                        @PathVariable String merchantId) {

        boolean success = userServise.buyProduct(userId, productId, merchantId);

        if (success)
            return ResponseEntity.ok(new ApiResponse("Product purchased successfully"));

        return ResponseEntity.status(400)
                .body(new ApiResponse("Purchase failed: check IDs, balance, or stock"));
    }

}
