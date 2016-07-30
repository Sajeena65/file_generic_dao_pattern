/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sajeena.generic.dao.impl;

import com.sajeena.generic.dao.ProductDAO;
import com.sajeena.generic.entity.product;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ProductDAOImpl implements ProductDAO {

    private List<product> productList = new ArrayList<>();

    @Override
    public boolean insert(product p) {
        return productList.add(p);

    }

    @Override
    public boolean delete(int id) {
        product p = getById(id);
        if (p != null) {
            return productList.remove(p);

        }
        return false;
    }

    @Override
    public product getById(int id) {
        for (product p : productList) {
            if (p.getId() == id) {
                return p;
            }

        }
        return null;
    }

    @Override
    public List<product> getAll() {
        return productList;
    }

}
