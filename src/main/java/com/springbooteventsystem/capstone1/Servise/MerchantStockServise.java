package com.springbooteventsystem.capstone1.Servise;

import com.springbooteventsystem.capstone1.Model.MerchantStock;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MerchantStockServise {

    ArrayList<MerchantStock> merchantStocks = new ArrayList<>();


    public ArrayList<MerchantStock> getAll() {
        return merchantStocks;
    }


    public boolean addStock(MerchantStock merchantStock) {
        return merchantStocks.add(merchantStock);
    }


    public boolean updateStock(String id, MerchantStock merchantStock) {
        for (int i = 0; i < merchantStocks.size(); i++) {
            if (merchantStocks.get(i).getId().equals(id)) {
                merchantStock.setId(id);
                merchantStocks.set(i, merchantStock);
                return true;
            }
        }
        return false;
    }


    public boolean deleteStock(String id) {
        for (int i = 0; i < merchantStocks.size(); i++) {
            if (merchantStocks.get(i).getId().equals(id)) {
                merchantStocks.remove(i);
                return true;
            }
        }
        return false;
    }


    public boolean addAmount(String productId, String merchantId, int amount) {

        for (MerchantStock stock : merchantStocks) {

            boolean sameProduct = stock.getProductId().equals(productId);
            boolean sameMerchant = stock.getMerchantId().equals(merchantId);

            if (sameProduct && sameMerchant) {
                stock.setStock(stock.getStock() + amount);
                return true;
            }
        }

        return false;
    }

}
