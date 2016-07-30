/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sajeena.generic.dao;

import com.sajeena.generic.entity.product;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface ProductDAO {
    boolean insert (product p);
    boolean delete(int id);
    product getById(int id);
    List<product> getAll();
    
}
