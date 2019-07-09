package ru.eltex;
import java.io.FileReader;
import java.io.IOException;
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

    public void readFromFileManager(String nameFile)
    {
        try
        {
            //String[]temp; // str2 - для main info, temp - для title and price
            FileReader manager = new FileReader(nameFile);
            Scanner sc = new Scanner(manager);
            String str = sc.nextLine();
            String[] str2 = str.split(" \\|\\| ");
            super.fromCSV(str2[0]);
            manager.close();
            String[] temp = str2[1].split("; ");
            for(String tmp: temp)
            {
                String[] tmp2 = tmp.split(": ");
                Sale prod = new Sale();
                prod.setTitle(tmp2[0]);
                prod.setPrice(tmp2[1]);
                product.add(prod);
            }

        } catch (IOException error) {
            System.out.println(error.getMessage());
        }
    }

    public void printListManager()
    {
        System.out.println("ID = " + super.getId() + "; FIO = " + super.getFio() + "; E-mail = " + super.getEmail() + "; Phone = " + super.getPhone() + " || " + this.product.toString());
    }
}