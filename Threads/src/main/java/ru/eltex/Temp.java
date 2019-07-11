package ru.eltex;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

class Temp
{
    static private int a = 0;
    static ReentrantLock lock = new ReentrantLock();
    static private Semaphore sem = new Semaphore(1,true);
    Temp()
    {
    }

    static public void counter() throws InterruptedException {
        sem.acquire();
        a = a + 1;
        System.out.println("a = " + a);
        sem.release();
    }



}