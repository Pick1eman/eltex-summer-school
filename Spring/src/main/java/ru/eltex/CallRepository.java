package ru.eltex;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CallRepository extends CrudRepository<Call, Integer> {
    //List<Call> findById(Integer Id);
}
