package com.springbooteventsystem.capstone1.Servise;

import com.springbooteventsystem.capstone1.Model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductServise {
   public final ArrayList<Product> products=new ArrayList<>();

   public ArrayList getAll(){
       return products;
   }
   private void addProduct(Product product){
       products.add(product);
   }

   public boolean deleteProduct(String id){
       for (int i=0;i<products.size();i++){
           if (products.get(i).getId().equals(id)){
               products.remove(i);
               return true;
        }
    }
    return false;

   }

   public boolean updateProduct(String id, Product product){
       for (int i=0 ; i<products.size();i++){
           if (products.get(i).getId().equals(id)){
               product.setId(id);
               products.set(i,product);
               return true;
           }
       }
return false;
   }
    public ArrayList<Product> getExpensiveProducts() {
        ArrayList<Product> result = new ArrayList<>();
        for(Product p : products) {
            if(p.getPrice() > 100) result.add(p);
        }
        return result;
    }
    public int getProductCount() {
        return products.size();
    }



    public void discountAllProducts() {
        for(Product p : products) {
            p.setPrice(p.getPrice() * 0.9);
        }
    }

    public ArrayList<Product> getProductsByCategory(String categoryId) {
        ArrayList<Product> result = new ArrayList<>();
        for(Product p : products) {
            if(p.getCategoryId().equals(categoryId)) result.add(p);
        }
        return result;
    }

    public ArrayList<Product> searchProductsByName(String name) {
        ArrayList<Product> result = new ArrayList<>();
        for(Product p : products) {
            if(p.getName().toLowerCase().contains(name.toLowerCase())) result.add(p);
        }
        return result;
    }




}
