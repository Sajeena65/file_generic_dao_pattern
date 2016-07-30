/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sajeena.generic;

import com.sajeena.generic.controller.productController;
import com.sajeena.generic.dao.ProductDAO;
import com.sajeena.generic.dao.impl.ProductDAOImpl;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
          ProductDAO productdao=new ProductDAOImpl();
        Scanner input=new Scanner(System.in);
        productController pc=new productController(input, productdao);
        pc.process();
        
    }
    
}
