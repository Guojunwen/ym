package com.gary.ym.controller;

import com.gary.ym.dataobject.Person;
import com.gary.ym.enums.ResultEnum;
import com.gary.ym.exception.YmException;
import com.gary.ym.form.PersonForm;
import com.gary.ym.service.PersonService;
import com.gary.ym.utils.KeyUtil;
import com.gary.ym.utils.ResultVOUtil;
import com.gary.ym.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Slf4j
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


    @RequestMapping("/save")
    public ResultVO save(@Valid PersonForm personForm, BindingResult buildingResult){
        if (buildingResult.hasErrors()){
            log.error("[添加队员] 参数不正确,orderForm={}"+personForm);
            throw new YmException(ResultEnum.PARAM_ERROR.getCode(),
                    buildingResult.getFieldError().getDefaultMessage());
        }
        Person person=new Person();
        BeanUtils.copyProperties(personForm,person);
        person.setCreateTime(new Date());
        person.setId(KeyUtil.genUniqueKey());
        return ResultVOUtil.success();
    }

}
