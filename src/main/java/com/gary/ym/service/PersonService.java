package com.gary.ym.service;

import com.gary.ym.dataobject.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PersonService {
    Person findOne(String id);

    Page<Person> findAll(Pageable pageable);

    Person save(Person person);

    List<Person> findByLevel(String Level);
}
