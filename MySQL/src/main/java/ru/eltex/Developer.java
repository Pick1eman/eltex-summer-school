package ru.eltex;


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


    public void readFromFileDeveloper(String nameFile) throws IOException, SQLException
    {
        Properties property = new Properties();
        FileInputStream fileInputStream = new FileInputStream("src/main/java/resources/db.properties");
        property.load(fileInputStream);
        Connection connection = DriverManager.getConnection(property.getProperty("db.host"), property.getProperty("db.user"), property.getProperty("db.password"));
        Statement statement = connection.createStatement();
        statement.execute("CREATE TABLE IF NOT EXISTS developers(id Integer(11), fio varchar(50), email varchar(70), phone varchar(13));");
        statement.execute("CREATE TABLE IF NOT EXISTS languages(id Integer(11), language varchar(50));");
        statement.execute("CREATE TABLE IF NOT EXISTS devLangsID(id Integer(11), id_dev Integer(11), id_lang Integer(11));");
        statement.executeUpdate("delete from developers where id >= 0");
        statement.executeUpdate("delete from languages where id >= 0");
        statement.executeUpdate("delete from devLangsID where id >= 0");
        FileReader developer = new FileReader(nameFile);
        Scanner sc = new Scanner(developer);
        int countLangs = 0;
        while (sc.hasNextLine())
        {
            ArrayList<Languages> languages = new ArrayList<>();
            String line = sc.nextLine();
            String []temp1 = line.split(" \\|\\| ");
            String []temp2 = temp1[0].split("; ");
            String []temp3 = temp1[1].split(", ");
            super.setId(temp2[0]);
            super.setFio(temp2[1]);
            super.setEmail(temp2[2]);
            super.setPhone(temp2[3]);
            for (int i = 0; i < temp3.length; i++)
            {
                languages.add(new Languages(temp3[i]));
                int a = 1, numLang = 0;
                ResultSet resultSet = statement.executeQuery("SELECT * FROM languages");
                for (int j = 0; resultSet.next(); j++)//while (resultSet.next())
                {
                    if (temp3[i].equals(resultSet.getString("language")))
                    {
                        a = 0;
                        numLang = j;
                        break;
                    }
                }
                if (a != 0)
                {
                    numLang = countLangs;
                    statement.executeUpdate("INSERT INTO languages value(" + countLangs + ",'" + temp3[i] + "');");
                    countLangs++;
                }
                statement.executeUpdate("INSERT INTO devLangsID value(" + (Integer.parseInt(super.getId())*(temp3.length+1) + i) + "," + Integer.parseInt(getId()) + "," + numLang + ");");
            }
            statement.executeUpdate("INSERT INTO developers VALUES(" + super.getId() + ",'" + super.getFio() + "','" + super.getEmail() + "','" + super.getPhone() + "');");
        }
        connection.close();
    }
}