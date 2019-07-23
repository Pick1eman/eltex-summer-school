package ru.eltex;
//import jdk.nashorn.internal.runtime.Property;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;
import java.util.ArrayList;

class Developer extends User
{
    private ArrayList<String> language = new ArrayList<>();

    public void setLanguage(String language)
    {
        this.language.add(language);
    }

    public ArrayList<String> getLanguage()
    {
        return this.language;
    }

    public void readFromFileDeveloper(String nameFile) throws IOException, SQLException
    {
        Properties property = new Properties();
        FileInputStream fileInputStream = new FileInputStream("src/main/java/resources/db.properties");
        property.load(fileInputStream);
        Connection connection = DriverManager.getConnection(property.getProperty("db.host"), property.getProperty("db.user"), property.getProperty("db.password"));
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from developers");
        statement.executeUpdate("delete from developers where id >= 0");

        FileReader developer = new FileReader(nameFile);
        Scanner sc = new Scanner(developer);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            String[] str2 = str.split(" \\|\\| ");
            super.fromCSV(str2[0]);
            developer.close();
            String[] temp = str2[1].split(", ");
            String[] str3 = str2[0].split("; ");
            int size = temp.length;
            for (int i = 0; i < size; i++) {
                setLanguage(temp[i]);
            }
            System.out.println("insert into developers ('" + str3[0] + "','" + str3[1] + "','" + str3[2] + "','" + str3[3] + "','" + str2[1] + "');");
            statement.executeUpdate("insert into developers value(" + str3[0] + ",'" + str3[1] + "','" + str3[2] + "','" + str3[3] + "','" + str2[1] + "');");
        }
        connection.close();
    }


    public void printListDeveloper()
    {
        System.out.println("ID = " + super.getId() + "; FIO = " + super.getFio() + "; E-mail = " + super.getEmail() + "; Phone = " + super.getPhone() + " || " + this.language.toString());
    }

}