package com.springbooteventsystem.capstone1.Servise;

import com.springbooteventsystem.capstone1.Model.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CategoryServise {
    ArrayList<Category>categories=new ArrayList<>();
    public ArrayList getall(){
        return categories;
    }
    public boolean add(Category category){
        return categories.add(category);
    }
    public boolean updateCategory(String id , Category category){
        for (int i = 0;i<categories.size();i++){
            if (categories.get(i).getId().equals(id)){
                category.setId(id);
                categories.set(i,category);
                return true;
            }
        }
        return false;
    }
    public boolean deleteCatogory(String id){
        for (int i=0;i<categories.size();i++){
            if (categories.get(i).getId().equals(id)){
                categories.remove(i);
                return true;
            }
        }
        return false;
    }
}
