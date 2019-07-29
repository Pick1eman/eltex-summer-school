package ru.eltex;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "temp")
public class User
{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Getter @Setter
    private Integer id;
    @Getter @Setter
    private String fio;
    User(String fio)
    {
        setFio(fio);
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Passport passport;
}
