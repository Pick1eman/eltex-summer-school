package ru.eltex;
import java.util.Scanner;

class Main{
    public static void main(String args[])
    {
        Manager a = new Manager();
        Developer b = new Developer();
        a.readFromFileManager("/home/user/Рабочий стол/eltex-summer-school/Accounts/src/main/resources/Managers.csv");
        a.printListManager();
        b.readFromFileDeveloper("/home/user/Рабочий стол/eltex-summer-school/Accounts/src/main/resources/Developers.csv");
        b.printListDeveloper();
    }

}