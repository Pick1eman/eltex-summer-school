package ru.eltex;

import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

class Sale
{
    @Getter
    @Setter
    private String title;
    @Getter
    @Setter
    private String price;

    Sale(String title, String price)
    {
        setTitle(title);
        setPrice(price);
    }

    @Override
    public String toString() {
        return this.title + " " + this.price;
    }
}