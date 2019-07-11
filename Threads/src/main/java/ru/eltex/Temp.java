package ru.eltex;

class Temp
{
    static private int a = 0;
    Temp()
    {
    }

    static public synchronized void counter()
    {
        a = a + 1;
        System.out.println("a = " + a);
    }

}