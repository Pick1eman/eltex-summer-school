package ru.eltex;
import java.sql.*;
import java.util.Scanner;

class Main{
    //public static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/users";
    public static void main(String args[])
    {
        Manager manager = new Manager();
        manager.tempAdd();
        /*try{
            Connection connection = DriverManager.getConnection(DB_URL,"root","2973");
            Statement statement = connection.createStatement();
            developer.readFromFileDeveloper("/home/user/Рабочий стол/eltex-summer-school/MySQL/resources/Developers.csv");
            manager.readFromFileManager("/home/user/Рабочий стол/eltex-summer-school/MySQL/resources/Managers.csv");
            connection.close();
        } catch (SQLException error)
        {
            System.out.println(error.getMessage());
        }
*/
    }
}