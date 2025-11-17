package com.springbooteventsystem.capstone1.Servise;

import com.springbooteventsystem.capstone1.Model.Merchant;
import com.springbooteventsystem.capstone1.Model.MerchantStock;
import com.springbooteventsystem.capstone1.Model.Product;
import com.springbooteventsystem.capstone1.Model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor

public class UserServise {
    private final ProductServise productServise;
    private final MerchantServise merchantServise;

    ArrayList<User> users = new ArrayList<>();

    public ArrayList<User> getAllUser() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);

    }

    public boolean updateUser(String id, User user) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(id)) {
                users.set(i, user);
                return true;
            }
        }
        return false;
    }

    public boolean deleteUser(String id) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(id)) {
                users.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean byProduct(String userid, String productId, String merchantId) {
        User user = null;
        Product product1 = null;
        MerchantStock stock = null;
        for (User user1 : users) {
            if (user1.getId().equals(userid)) {
                user = user1;
                break;

            }
        }
        Product product = null;
        for (Product p : productServise.products) {
            if (p.getId().equals(productId)) {
                product = p;
                break;
            }
        }
//
//        MerchantStock stock1 = null;
//        for (MerchantStock ms : merchantStockServise.getAll()) {
//            if (ms.getProductid().equals(productId) && ms.getMerchantid().equals(merchantId)) {
//                stock1 = ms;
//                break;
//            }
//        }
        if (user == null && product == null && stock == null) {
            return false;
        }
        if (stock.getStock() <= 0) {
            return false;
        }

//    if (user.getBalance()<product.getPrice()){
//        return false;
//    }

        stock.setStock(stock.getStock() );
        user.setBalance(user.getBalance());

        return true;

    }


}

