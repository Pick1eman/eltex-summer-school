package ru.eltex;
import java.util.Scanner;

abstract class User implements CSV // id ; fio ; email ; phone
{
    private Integer id;
    private String fio;
    private String phone;
    private String email;


    public Integer getId()
    {
        return this.id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getFio()
    {
        return this.fio;
    }

    public void setFio(String str)
    {
        this.fio = str;
    }
    public String getPhone()
    {
        return this.phone;
    }

    public void setPhone(String str)
    {
        this.phone = str;
    }
    public String getEmail()
    {
        return this.email;
    }

    public void setEmail(String str)
    {
        this.email = str;
    }

    public String toCSV()
    {
        return this.id.toString() + " ; " + this.fio + " ; " + this.email + " ; " + this.phone;
    }

    public void fromCSV(String str)
    {
        String []arr = str.split(" ; ");
        this.id = Integer.valueOf(arr[0]);
    }

}