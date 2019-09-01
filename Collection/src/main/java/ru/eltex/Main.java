package ru.eltex;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Integer N = 100000;
        Double t = 1e-9;

        HashSet<Integer> test1 = new HashSet<>();
        long start = System.nanoTime();
        for (int i = 0; i < N; i++){
            test1.add(i);
        }
        long end = System.nanoTime();
        Double res = (end - start) * t;
        System.out.println("HashSet time = " + res);

        HashMap<Integer, Integer> test2 = new HashMap<>();
        start = System.nanoTime();
        for (int i = 0; i < N; i++){
            test2.put(i, i);
        }
        end = System.nanoTime();
        res = (end - start) * t;
        System.out.println("HashMap time = " + res);

        ArrayList<Integer> test3 = new ArrayList<>();
        start = System.nanoTime();
        for (int i = 0; i < N; i++){
            test3.add(i);
        }
        end = System.nanoTime();
        res = (end - start) * t;
        System.out.println("ArrayList time = " + res);

        LinkedList<Integer> test4 = new LinkedList<>();
        start = System.nanoTime();
        for (int i = 0; i < N; i++){
            test4.add(i);
        }
        end = System.nanoTime();
        res = (end - start) * t;
        System.out.println("LinkedList time = " + res);

        TreeSet<Integer> test5 = new TreeSet<>();
        start = System.nanoTime();
        for (int i = 0; i < N; i++){
            test5.add(i);
        }
        end = System.nanoTime();
        res = (end - start) * t;
        System.out.println("TreeSet time = " + res);
    }
}
