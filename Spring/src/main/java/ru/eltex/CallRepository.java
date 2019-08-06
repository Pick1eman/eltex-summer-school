package ru.eltex;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CallRepository extends CrudRepository<Call2, Integer> {
    //List<Call2> findById(Integer Id);
}
