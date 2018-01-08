package com.gary.ym.service.impl;

import com.gary.ym.dataobject.Person;
import com.gary.ym.repository.PersonRepository;
import com.gary.ym.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository repository;

    @Override
    public Person findOne(String id) {
        return repository.findOne(id);
    }

    @Override
    public Page<Person> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Page<Person> findLikeName(String name,Pageable pageable) {
        return repository.findByNameContains(name,pageable);
    }

    @Override
    public Person save(Person person) {
        return repository.save(person);
    }

    @Override
    public List<Person> findByLevel(String level) {
        return repository.findByLevel(level);
    }
}
