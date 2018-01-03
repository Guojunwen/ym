package com.gary.ym.controller;

import com.gary.ym.dataobject.Person;
import com.gary.ym.service.PersonService;
import com.gary.ym.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sys/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping("/list")
    public Page<Person> list(@RequestParam(value = "page",defaultValue = "0") Integer page,
                         @RequestParam(value = "size",defaultValue = "10") Integer size) {
        PageRequest request=new PageRequest(page,size);
        Page<Person> personList=personService.findAll(request);
        return personList;
    }

}
