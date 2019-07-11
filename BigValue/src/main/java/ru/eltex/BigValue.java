package ru.eltex;
import java.math.BigInteger;

public class BigValue {
    public static void main(String[] args) {
        BigInteger a = BigInteger.valueOf(2);
        for (int i = 0; i < 1000-1; i++)
        {
            a = a.multiply(BigInteger.valueOf(2));
        }
        System.out.println(a);
    }
}
