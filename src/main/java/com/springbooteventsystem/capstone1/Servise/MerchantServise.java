package com.springbooteventsystem.capstone1.Servise;

import com.springbooteventsystem.capstone1.Model.Merchant;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MerchantServise {

    ArrayList<Merchant> merchants = new ArrayList<>();


    public ArrayList<Merchant> getAll() {
        return merchants;
    }


    public boolean addMerchant(Merchant merchant) {
        return merchants.add(merchant);
    }


    public boolean updateMerchant(String id, Merchant merchant) {
        for (int i = 0; i < merchants.size(); i++) {
            if (merchants.get(i).getId().equals(id)) {
                merchant.setId(id);
                merchants.set(i, merchant);
                return true;
            }
        }
        return false;
    }


    public boolean deleteMerchant(String id) {
        for (int i = 0; i < merchants.size(); i++) {
            if (merchants.get(i).getId().equals(id)) {
                merchants.remove(i);
                return true;
            }
        }
        return false;
    }
}
