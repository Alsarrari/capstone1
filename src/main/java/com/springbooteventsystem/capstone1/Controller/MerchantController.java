package com.springbooteventsystem.capstone1.Controller;

import com.springbooteventsystem.capstone1.ApiResponse.ApiResponse;
import com.springbooteventsystem.capstone1.Model.Merchant;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Data
@RequiredArgsConstructor
@RequestMapping("/api/m1/merchanr")
public class MerchantController {
    private final MerchantController merchantServise;
    @GetMapping("/get")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(merchantServise.getMerchantServise());

    }
    @PostMapping("/add")
    public ResponseEntity<?> addMerchant(@Valid @RequestBody Merchant merchant){
        merchantServise.addMerchant(merchant);
        return ResponseEntity.status(200).body(new ApiResponse("merchant add"));

    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateMerchant(@PathVariable String id ,@Valid @RequestBody  Merchant merchant){
        MerchantController merchantService;
        //boolean updated = merchantService.updateMerchant(id, merchant);
    //if (updated)
        return ResponseEntity.ok(new ApiResponse("merchant update"));
    //return ResponseEntity.status(400).body(new ApiResponse("merchant not found"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMerchant(@PathVariable String id){
        //boolean delete = merchantServise.deleteMerchant(id);
        //if (delete)
            return ResponseEntity.ok(new ApiResponse("merchant delete"));
        //return ResponseEntity.status(400).body(new ApiResponse("merchant not found"));
    }




}
