package ru.eltex;
import java.util.Scanner;

class Main{
    public static void main(String args[])
    {
        Manager a = new Manager();
        Sale product = new Sale("Cats","10000");
        a.addProduct(product);
        System.out.println("Product: " + product.getTitle() + "; Cost: " + product.getPrice());
    }

}