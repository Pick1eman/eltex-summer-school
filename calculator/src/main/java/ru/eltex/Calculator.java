package ru.eltex;
import java.util.Scanner;

class Calculator{
    public static void main(String args[])
    {
        Double op1 = 0.0;
        Double op2 = 0.0;
        Double result = 0.0;

        System.out.println("Введите выражение");
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] strs = str.split(" ");
        op1 = Double.parseDouble(strs[0]);
        op2 = Double.parseDouble(strs[2]);
        if (strs[1].compareTo("+") == 0)
        {
            result = op1 + op2;
        } else if (strs[1].compareTo("-") == 0)
        {
            result = op1 - op2;
        } else if (strs[1].compareTo("*") == 0)
        {
            result = op1 - op2;
        } else if (strs[1].compareTo("/") == 0)
        {
            if (op2 == 0)
            {
                System.out.println("Деление на нуль невозможно");
                return;
            }
            result = op1 - op2;
        } else {
            System.out.println("Неверная операция");
        }
        System.out.println("Результат = " + result);
    }

}