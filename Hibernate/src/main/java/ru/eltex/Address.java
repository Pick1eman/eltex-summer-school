package ru.eltex;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "tempAddr")
public class Address
{
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id")
    @Getter @Setter
    private Integer id;
    @Getter @Setter
    private String city;
    @Getter @Setter
    private String street;
    @Getter @Setter
    private String building;

    @OneToMany(mappedBy = "tempAddr", fetch = FetchType.EAGER)
    private Collection <User> tenants;
}
