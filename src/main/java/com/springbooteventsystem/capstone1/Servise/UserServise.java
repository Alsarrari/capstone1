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
    private final MerchantStockServise merchantStockServise;

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
                user.setId(id);
                users.set(i, user);
                return true;
            }
        }
        return false;
    }

    public boolean deleteUser(String id) {
        return users.removeIf(u -> u.getId().equals(id));
    }

    public boolean buyProduct(String userId, String productId, String merchantId) {

        User user = null;
        Product product = null;
        MerchantStock stock = null;

        // find user
        for (User u : users) {
            if (u.getId().equals(userId)) {
                user = u;
                break;
            }
        }

        // find product
        for (Product p : productServise.products) {
            if (p.getId().equals(productId)) {
                product = p;
                break;
            }
        }

        // find stock
        for (MerchantStock ms : merchantStockServise.getAll()) {
            if (ms.getProductId().equals(productId)
                    && ms.getMerchantId().equals(merchantId)) {
                stock = ms;
                break;
            }
        }

        // validation
        if (user == null || product == null || stock == null) {
            return false;
        }

        if (stock.getStock() <= 0) {
            return false;
        }

        if (user.getBalance() < product.getPrice()) {
            return false;
        }

        // do purchase
        stock.setStock(stock.getStock() - 1);
        user.setBalance(user.getBalance() - product.getPrice());

        return true;
    }
}

