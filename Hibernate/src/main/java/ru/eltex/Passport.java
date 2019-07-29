package ru.eltex;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tempPass")
public class Passport {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Getter
    @Setter
    private Integer id;
    @Getter
    @Setter
    private Integer series;
    @Getter
    @Setter
    private Integer number;

    Passport(Integer number, Integer series)
    {
        setNumber(number);
        setSeries(series);
    }

    @OneToOne(mappedBy = "passport")
    private User user;
}
