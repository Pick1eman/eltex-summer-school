package ru.eltex;

class MyThread implements Runnable
{
    private Integer numThread = 0;
    public void run()
    {
        Temp.counter();
    }

    MyThread()
    {
    }

}