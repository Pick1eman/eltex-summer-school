package ru.eltex;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Lang
{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Getter @Setter
    private String title;

    @ManyToMany(mappedBy = "lang", fetch = FetchType.EAGER)
    private Collection<User> users;
}
