package ru.eltex;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

class Main{
    public static void main(String args[]) throws IOException, SQLException
    {
        Manager manager = new Manager();
        Developer developer = new Developer();
        manager.readFromFileManager("src/main/java/resources/Managers.csv");
        developer.readFromFileDeveloper("src/main/java/resources/Developers.csv");

        /*try{
            Connection connection = DriverManager.getConnection(DB_URL,"root","2973");
            Statement statement = connection.createStatement();
            developer.readFromFileDeveloper("src/main/java/resources/Developers.csv");
            manager.readFromFileManager("src/main/java/resources/Managers.csv");
            connection.close();
        } catch (SQLException error)
        {
            System.out.println(error.getMessage());
        }
*/
        unionDB();
    }

    public static void unionDB() throws IOException, SQLException {
        Properties property = new Properties();
        FileInputStream fileInputStream = new FileInputStream("src/main/java/resources/db.properties");
        property.load(fileInputStream);
        Connection connection = DriverManager.getConnection(property.getProperty("db.host"), property.getProperty("db.user"), property.getProperty("db.password"));
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT id, fio, email, phone FROM developers UNION SELECT id, fio, email, phone FROM managers;");
        while (resultSet.next())
        {
            Integer id = resultSet.getInt("id");
            String fio = resultSet.getString("fio");
            String email = resultSet.getString("email");
            String phone = resultSet.getString("phone");
            System.out.println(id + " " + fio + " " + email + " " + phone);
        }
        connection.close();
    }
}