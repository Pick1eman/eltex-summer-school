package ru.eltex;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Main2
{
    public static void main(String[] args) throws InterruptedException {
        //ExecutorService exec = Executors.newCachedThreadPool();
        ExecutorService exec = Executors.newFixedThreadPool(10);
        Runnable r = new MyThread();

        long startTimer = System.nanoTime();

        for (int i = 0; i < 10000; i++)
        {
            exec.submit(r);
        }
        exec.shutdown();
        exec.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        long stopTimer = System.nanoTime();
        long elapsed = stopTimer - startTimer;

        System.out.println("Timer = " + elapsed*Math.pow(10,-9));

    }

}