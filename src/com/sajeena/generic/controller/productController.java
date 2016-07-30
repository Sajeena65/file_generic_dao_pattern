/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sajeena.generic.controller;

import com.sajeena.generic.dao.ProductDAO;
import com.sajeena.generic.entity.product;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class productController {

    private Scanner input;
    ProductDAO productdao;

    public productController(Scanner input, ProductDAO productdao) {
        this.productdao = productdao;
        this.input = input;

    }

    private void menu() {
        System.out.println("Product Details");
        System.out.println("===================================================");
        System.out.println("1. Add Product: ");
        System.out.println("2. Delete Product: ");
        System.out.println("3. Search Product By Id: ");
        System.out.println("4. Show All: ");
        System.out.println("5. Write to File: ");
        System.out.println("6. Exit: ");
        System.out.println("Enter your choice[1-5]: ");
    }

    private void add() {
        product p = new product();

        System.out.println("Enter ID: ");
        p.setId(input.nextInt());
        System.out.println("Enter Name: ");
        p.setName(input.next());
        System.out.println("Enter Price: ");
        p.setPrice(input.nextDouble());
        System.out.println("Enter Quantity: ");
        p.setQuantity(input.nextInt());
        System.out.println("Enter Status: ");
        p.setStatus(input.nextBoolean());
        if (productdao.insert(p)) {
            System.out.println("Inserted Successfully.");

        } else {
            System.out.println("Data Full.");
        }

    }

    private void delete() {

        System.out.print("Enter Product Id to Delete : ");
        if (productdao.delete(input.nextInt())) {
            System.out.println("Enquiry deleted successfully.");
        } else {
            System.out.println("Product not found.");
        }

    }

    private void search() {

        System.out.print("Enter Product Id to Search : ");
        product pr = productdao.getById(input.nextInt());
        if (pr != null) {
            System.out.println("Product ID : " + pr.getId());
            System.out.println("Name: " + pr.getName());
            System.out.println("Price : " + pr.getPrice());
            System.out.println("Quantity : " + pr.getQuantity());
            System.out.println("Status : " + pr.isStatus());
        } else {
            System.out.println("Id not found.");
        }

    }

    private void showAll() {

        productdao.getAll().forEach(p -> {
            System.out.println("=======================================");
            System.out.println("Product ID: " + p.getId());
            System.out.println("Name: " + p.getName());
            System.out.println("Price: " + p.getPrice());
            System.out.println("Quantity: " + p.getQuantity());
            System.out.println("Status: " + p.isStatus());
        });
    }

    private void writeToFile() throws IOException {
        try (FileWriter writer = new FileWriter("C:/Users/Admin/Desktop/output.txt");
                BufferedWriter bufferedwriter = new BufferedWriter(writer)) {

            productdao.getAll().forEach((product p) -> {
                try {

                    bufferedwriter.write("Product ID:"+p.getId() + " Name:" + p.getName() + " Price:" + p.getPrice() + " Quantity:" + p.getQuantity() + " Status:" + p.isStatus());
                    bufferedwriter.newLine();

                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            });
            System.out.println("Write Successful.");
            bufferedwriter.close();
        }

    }

    public void process() throws IOException {
        while (true) {
            menu();
            int ch = input.nextInt();
            switch (ch) {
                case 1:
                    while (true) {
                        add();
                        System.out.print("Do you want to add another Product?[Y/N] : ");
                        if (input.next().equalsIgnoreCase("n")) {
                            break;

                        }

                    }
                    break;
                case 2:
                    while (true) {
                        delete();
                        System.out.println("Do you want to delete another Product? [Y/N] : ");
                        if (input.next().equalsIgnoreCase("N")) {
                            break;
                        }
                    }

                    break;

                case 3:
                    while (true) {
                        search();
                        System.out.println("Continue Search?[Y/N] : ");
                        if (input.next().equalsIgnoreCase("N")) {
                            break;
                        }
                        System.out.println("");
                    }

                    break;
                case 4:
                    showAll();
                    break;
                case 5:
                    writeToFile();
                    break;
                case 6:

                    System.exit(0);
                    break;

            }
        }

    }
}
