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
        statement.execute("CREATE TABLE IF NOT EXISTS managers(id Integer(11), fio varchar(50), email varchar(70), phone varchar(12));");
        statement.executeUpdate("delete from managers where id >= 0");

        FileReader manager = new FileReader(nameFile);
        Scanner sc = new Scanner(manager);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            String[] str2 = str.split(" \\|\\| ");
            super.fromCSV(str2[0]);
            manager.close();
            String[] temp = str2[1].split("; ");
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
            connection.close();
        }
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

    public void tempAdd() throws IOException, SQLException {
        Properties property = new Properties();
        FileInputStream fileInputStream = new FileInputStream("src/main/java/resources/db.properties");
        property.load(fileInputStream);
        Connection connection = DriverManager.getConnection(property.getProperty("db.host"), property.getProperty("db.user"), property.getProperty("db.password"));
        Statement statement = connection.createStatement();
        statement.execute("CREATE TABLE IF NOT EXISTS managers(id Integer(11), fio varchar(50), email varchar(70), phone varchar(12));");
        connection.setAutoCommit(false);

        long startTimer = System.nanoTime();
        for (int i = 0; i < 1000; i++)
        {
            statement.executeUpdate("INSERT INTO managers VALUE (" + i + ",'is741s" + i + "','temp2','asdsa');");
        }
        long stopTimer = System.nanoTime();
        long elapsed = stopTimer - startTimer;
        System.out.println("Timer with tran = " + elapsed/pow(10,9) + " seconds");
        connection.commit();

        connection.close();
    }
}