package ru.eltex;

class MyThread implements Runnable
{
    private Integer numThread = 0;
    public void run()
    {
        Temp a = new Temp();
        try {
            a.counter();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    MyThread()
    {
    }

}