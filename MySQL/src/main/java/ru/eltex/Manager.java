package ru.eltex;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
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
            String DB_URL = "jdbc:mysql://127.0.0.1:3306/users";
            Connection connection = DriverManager.getConnection(DB_URL, "root", "2973");
            try {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("select * from managers");
                statement.executeUpdate("delete from managers where id >= 0");


                FileReader manager = new FileReader(nameFile);
                Scanner sc = new Scanner(manager);
                while (sc.hasNextLine()) {
                    String str = sc.nextLine();
                    String[] str2 = str.split(" \\|\\| ");
                    super.fromCSV(str2[0]);
                    manager.close();
                    //String[] temp = str2[1].split("; ");
                    String[] str3 = str2[0].split("; ");
                    String[] tmp2 = str2[1].split(": ");
                    /*for (String tmp : temp) {
                        tmp2 = tmp.split(": ");
                        Sale prod = new Sale();
                        prod.setTitle(tmp2[0]);
                        prod.setPrice(tmp2[1]);
                        product.add(prod);
                    }*/
                    statement.executeUpdate("insert into managers value(" + str3[0] + ",'" + str3[1] + "','" + str3[2] + "','" + str3[3] + "','" + tmp2[0] + "'," + tmp2[1] + ");");
                }
            } catch (SQLException error)
            {
                System.out.println(error.getMessage());
            }
            finally {
                connection.close();
            }

        } catch (IOException | SQLException error) {
            System.out.println(error.getMessage());
        }
    }

    public void printListManager()
    {
        System.out.println("ID = " + super.getId() + "; FIO = " + super.getFio() + "; E-mail = " + super.getEmail() + "; Phone = " + super.getPhone() + " || " + this.product.toString());
    }
}