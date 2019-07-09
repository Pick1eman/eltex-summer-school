package ru.eltex;
import java.util.ArrayList;
import java.util.Scanner;


class Manager extends User
{
    private ArrayList<Sale> product = new ArrayList<>();

    public ArrayList<Sale> getMan()
    {
        return product;
    }

    public void setMan(ArrayList<Sale> product)
    {
        this.product = product;
    }

    public Integer countProduct()
    {
        return this.product.size();
    }

    public void addProduct(Sale product)
    {
        this.product.add(product);
    }
}