package ru.eltex;

import lombok.Getter;
import lombok.Setter;

public class Languages
{
    @Getter
    @Setter
    private String lang;
    Languages(String str)
    {
        this.lang = str;
    }

}
