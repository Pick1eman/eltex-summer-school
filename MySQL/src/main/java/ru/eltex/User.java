package ru.eltex;
import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

abstract class User implements CSV // id ; fio ; email ; phone
{
    @Getter
    @Setter
    private String id;
    @Getter
    @Setter
    private String fio;
    @Getter
    @Setter
    private String phone;
    @Getter
    @Setter
    private String email;


    public String toCSV()
    {
        return this.id + "; " + this.fio + "; " + this.email + "; " + this.phone;
    }

    public void fromCSV(String str)
    {
        String []arr = str.split("; ");
        setId(arr[0]);
        setFio(arr[1]);
        setEmail(arr[2]);
        setPhone(arr[3]);
    }

}