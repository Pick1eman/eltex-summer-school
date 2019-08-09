package ru.eltex;

import lombok.Getter;
import lombok.Setter;


class User {
    @Getter
    @Setter
    private Integer id;
    @Getter
    @Setter
    private String fio;
    @Getter
    @Setter
    private String phone;

    User(Integer id, String fio, String phone)
    {
        setFio(fio);
        setId(id);
        setPhone(phone);
    }

}