package ru.eltex;

class Main2
{
    public static void main(String[] args)
    {
        Runnable r = new MyThread();
        for (int i = 0; i < 10; i++)
        {
            Thread th = new Thread(r);
            th.start();

        }
    }

}