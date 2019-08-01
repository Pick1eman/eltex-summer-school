package ru.eltex;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
class User {
    @Id
    @Getter
    @Setter
    private Integer id;
    @Getter
    @Setter
    private String fio;
    @Getter
    @Setter
    private String phone;
    @Setter @Getter
    private Integer id_call;

    User(Integer id, String fio, String phone)
    {
        setFio(fio);
        setId(id);
        setPhone(phone);
    }

}