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
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(userServise.getAllUser());
    }
    @PostMapping("/add")
    public ResponseEntity<?> addUser(@Valid @RequestBody User user){
        userServise.addUser(user);
        return ResponseEntity.status(200).body(new ApiResponse("user add"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateUser(@PathVariable String id ,@RequestBody@Valid  User user){
        boolean update=userServise.deleteUser(id);
        if (update)
            return ResponseEntity.ok(new ApiResponse("user update"));
        return ResponseEntity.status(400).body(new ApiResponse("user not found"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable String id ){
        boolean delete=userServise.deleteUser(id);
        if (delete)
            return ResponseEntity.ok(new ApiResponse("delete user"));
        return ResponseEntity.status(400).body(new ApiResponse("user not found"));
    }

    @PutMapping("/buy/{userId}/{productId}/{merchantId}")
    public ResponseEntity<?> buyProduct(@PathVariable String userId,
                                        @PathVariable String productId,
                                        @PathVariable String merchantId) {

        boolean success = userServise.byProduct(userId, productId, merchantId);

        if (success)
            return ResponseEntity.ok(new ApiResponse("Product purchased successfully"));
        return ResponseEntity.status(400).body(new ApiResponse("Purchase failed: check user balance, product stock, or IDs"));
    }



}
