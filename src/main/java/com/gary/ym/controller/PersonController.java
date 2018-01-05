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
import org.springframework.data.domain.Sort;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
    @ResponseBody
    public List<Person> list(Integer rows,Integer page,String sidx,String sord) {
        Sort sort;
        if ("desc".equals(sord)){
            sort = new Sort(Sort.Direction.DESC, sidx);
        }else{
            sort = new Sort(Sort.Direction.ASC, sidx);
        }
        PageRequest pageRequest=new PageRequest(page-1,rows,sort);
        Page<Person> personList=personService.findAll(pageRequest);
        return personList.getContent();
    }


    @RequestMapping("/save")
    @ResponseBody
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
        Person result=personService.save(person);
        if (result!=null){
            log.info("[保存成功],orderForm={}"+personForm);
            return ResultVOUtil.success();
        }else{
            log.error("[保存失败],orderForm={}"+personForm);
            return ResultVOUtil.error(500,"error");
        }

    }

}
