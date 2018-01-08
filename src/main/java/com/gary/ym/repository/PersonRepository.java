package com.gary.ym.repository;

import com.gary.ym.dataobject.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person,String> {
    List<Person> findByLevel(String level);

    Page<Person> findByNameContains(String name,Pageable pageable);
}
