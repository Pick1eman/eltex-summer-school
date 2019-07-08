package ru.eltex;
import java.util.Scanner;

class Sale
{
    private String title;
    private String price;

    Sale(String title, String price)
    {
        this.title = title;
        this.price = price;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getPrice()
    {
        return price;
    }

    public void setPrice(String price)
    {
        this.price = price;
    }
}