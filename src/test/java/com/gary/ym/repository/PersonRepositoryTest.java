package com.gary.ym.repository;

import com.gary.ym.dataobject.Person;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository repository;

    @Test
    public void saveTest(){
        Person person=new Person();
        person.setId("001");
        person.setBattleId("master#5273");
        person.setLevel("A");
        person.setQq("1622985514");
        person.setName("master");
        person.setCreateTime(new Date());
        Person result=repository.save(person);
        Assert.assertNotNull(result);
    }

}