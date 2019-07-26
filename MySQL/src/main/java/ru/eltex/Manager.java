package ru.eltex;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

import static java.lang.Math.pow;


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

    public void readFromFileManager(String nameFile) throws IOException, SQLException
    {
        Properties property = new Properties();
        FileInputStream fileInputStream = new FileInputStream("src/main/java/resources/db.properties");
        property.load(fileInputStream);
        Connection connection = DriverManager.getConnection(property.getProperty("db.host"), property.getProperty("db.user"), property.getProperty("db.password"));
        Statement statement = connection.createStatement();
        statement.execute("CREATE TABLE IF NOT EXISTS managers(id Integer(11), fio varchar(50), email varchar(70), phone varchar(13));");
        statement.execute("CREATE TABLE IF NOT EXISTS sales(id Integer(11), id_man Integer(11), title varchar(50), price Integer(11));");
        statement.executeUpdate("delete from managers where id >= 0");
        statement.executeUpdate("delete from sales where id >= 0");
        FileReader developer = new FileReader(nameFile);
        Scanner sc = new Scanner(developer);
        int countSale = 0;
        while (sc.hasNextLine())
        {
            ArrayList<Sale> sales = new ArrayList<>();
            String line = sc.nextLine();
            String []temp1 = line.split(" \\|\\| ");
            String []temp2 = temp1[0].split("; ");
            String []temp3 = temp1[1].split("; ");
            super.setId(temp2[0]);
            super.setFio(temp2[1]);
            super.setEmail(temp2[2]);
            super.setPhone(temp2[3]);
            for (int i = 0; i < temp3.length; i++)
            {
                String []temp4 = temp3[i].split(", ");
                sales.add(new Sale(temp4[0], temp4[1]));
                statement.executeUpdate("INSERT INTO sales VALUES(" + (Integer.parseInt(super.getId())*(temp3.length+1) + i) + "," + super.getId() + ",'" + temp4[0] + "','" + temp4[1] + "');");
            }
            statement.executeUpdate("INSERT INTO managers VALUES(" + super.getId() + ",'" + super.getFio() + "','" + super.getEmail() + "','" + super.getPhone() + "');");
        }
        connection.close();
    }

    public void printListManager()
    {
        System.out.println("ID = " + super.getId() + "; FIO = " + super.getFio() + "; E-mail = " + super.getEmail() + "; Phone = " + super.getPhone() + " || " + this.product.toString());
    }

    public void readFromMySQL() throws IOException, SQLException
    {
        Properties property = new Properties();
        FileInputStream fileInputStream = new FileInputStream("src/main/java/resources/db.properties");
        property.load(fileInputStream);
        Connection connection = DriverManager.getConnection(property.getProperty("db.host"), property.getProperty("db.user"), property.getProperty("db.password"));
        String pathFile = "/user/home/Рабочий стол/eltex-summer-school/MySQL/resources";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from managers");
        FileWriter fileWriter = new FileWriter(pathFile);
        while (resultSet.next())
        {
            Integer id = resultSet.getInt("id");
            String fio = resultSet.getString("fio");
            String email = resultSet.getString("email");
            String phone = resultSet.getString("phone");
            String title = resultSet.getString("title");
            String price = resultSet.getString("price");
            System.out.println(id + fio + email + phone + title + price);
            fileWriter.write(id + "; " + fio + "; " + email + "; " + phone + "; " + title + "; " + price + "\n");
        }
        connection.close();
    }

}