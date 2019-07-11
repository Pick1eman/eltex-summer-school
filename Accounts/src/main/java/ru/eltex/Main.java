package ru.eltex;
import java.lang.reflect.Field;
import java.util.Scanner;

class Main{
    public static void main(String args[])
    {
        /*Manager a = new Manager();
        Developer b = new Developer();
        a.readFromFileManager("/home/user/Рабочий стол/eltex-summer-school/Accounts/src/main/resources/Managers.csv");
        a.printListManager();
        b.readFromFileDeveloper("/home/user/Рабочий стол/eltex-summer-school/Accounts/src/main/resources/Developers.csv");
        b.printListDeveloper();
        */
        Class<User> userClass = User.class;
        Field[] userFiled = userClass.getDeclaredFields();
        for (Field fie: userFiled)
        {
            System.out.println(fie.getName());
        }
    }

}