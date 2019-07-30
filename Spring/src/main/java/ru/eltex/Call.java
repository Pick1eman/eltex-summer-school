package ru.eltex;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Call
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private Integer id;
    @Setter @Getter
    private Integer idA;
    @Setter @Getter
    private Integer idB;

    Call(Integer idA, Integer idB)
    {
        setIdA(idA);
        setIdB(idB);
    }
}