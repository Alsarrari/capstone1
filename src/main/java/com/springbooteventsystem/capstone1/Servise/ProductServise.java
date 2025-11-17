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
    public ArrayList<Product> getHighPriceProducts() {
        ArrayList<Product> result = new ArrayList<>();
        for (Product pro  : products) {
            if (pro.getPrice() > 100) {
                result.add(pro);
            }
        }
        return result;
    }
    public int getProductCount() {
        return products.size();
    }
    public boolean applyDiscount(String id) {
        for (Product p : products) {
            if (p.getId().equals(id)) {
                double newPrice = p.getPrice() * 0.90;
                p.setPrice(newPrice);
                return true;
            }
        }
        return false;
    }




}
