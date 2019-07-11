package ru.eltex;

import java.util.concurrent.locks.ReentrantLock;

class Temp
{
    static private int a = 0;
    static ReentrantLock lock = new ReentrantLock();
    Temp()
    {
    }

    static public void counter()
    {
        lock.lock();
        a = a + 1;
        System.out.println("a = " + a);
        lock.unlock();
    }



}