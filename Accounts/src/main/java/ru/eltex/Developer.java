package ru.eltex;
import java.io.FileReader;
import java.io.IOException;
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

    public void readFromFileDeveloper(String nameFile)
    {
        try
        {
            String[] str2,temp; // str2 - для main info, temp - для языков
            FileReader developer = new FileReader(nameFile);
            Scanner sc = new Scanner(developer);
            String str = sc.nextLine();
            str2 = str.split(" \\|\\| ");
            super.fromCSV(str2[0]);
            developer.close();
            temp = str2[1].split(", ");
            int size = temp.length;
            System.out.println(size);
            for(int i = 0; i < size; i++)
            {
                setLanguage(temp[i]);
            }


        } catch (IOException error) {
            System.out.println(error.getMessage());
        }
    }


    public void printListDeveloper()
    {
        System.out.println("ID = " + super.getId() + "; FIO = " + super.getFio() + "; E-mail = " + super.getEmail() + "; Phone = " + super.getPhone() + " || " + this.language.toString());
    }

}