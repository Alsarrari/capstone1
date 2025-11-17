package com.springbooteventsystem.capstone1.Controller;

import com.springbooteventsystem.capstone1.ApiResponse.ApiResponse;
import com.springbooteventsystem.capstone1.Model.Category;
import com.springbooteventsystem.capstone1.Servise.CategoryServise;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Data
@RequiredArgsConstructor
@RequestMapping("api/c1/category")
public class CategoryController {
    private final CategoryServise categoryServise;
    @GetMapping("/get")
    public ResponseEntity<?> getAllCategories() {
        return ResponseEntity.status(200).body(categoryServise);
    }
    @PostMapping("add")
    public ResponseEntity<?> addCategory(@Valid @RequestBody Category category){
        categoryServise.add(category);
        return ResponseEntity.status(200).body(new ApiResponse("category added"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable String id ,@Valid@RequestBody Category category){
        boolean isupdate=categoryServise.updateCategory(id, category);
        if (isupdate)
            return ResponseEntity.status(200).body(new ApiResponse("category update"));
        return ResponseEntity.status(400).body(new ApiResponse("category not update"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable String  id){
       boolean isdelete=categoryServise.deleteCatogory(id);
       if (isdelete)
           return ResponseEntity.status(200).body(new ApiResponse("category delete"));
       return ResponseEntity.status(400).body(new ApiResponse("category not found"));
    }
}
