package ru.eltex;

class Temp
{
    static private volatile int a = 0;
    Temp()
    {
    }

    static public void counter()
    {
        a = a + 1;
        System.out.println("a = " + a);
    }


}