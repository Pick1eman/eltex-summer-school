package ru.eltex;

import lombok.Getter;
import lombok.Setter;

public class User
{
    @Setter @Getter
    private Integer id;
    @Setter @Getter
    private String fio;
    @Setter @Getter
    private String phone;

    User(Integer id, String fio, String phone)
    {
        setId(id);
        setPhone(phone);
        setFio(fio);
    }
}
