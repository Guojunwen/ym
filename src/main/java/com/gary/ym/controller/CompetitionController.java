package com.gary.ym.controller;

import com.gary.ym.dataobject.Competition;
import com.gary.ym.dataobject.Person;
import com.gary.ym.enums.ResultEnum;
import com.gary.ym.exception.YmException;
import com.gary.ym.form.CompetitionForm;
import com.gary.ym.form.PersonForm;
import com.gary.ym.service.CompetitionService;
import com.gary.ym.service.PersonService;
import com.gary.ym.utils.JqgridPage;
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

@Slf4j
@RestController
@RequestMapping("/sys/competition")
public class CompetitionController {

    @Autowired
    private CompetitionService competitionService;


    @RequestMapping("/save")
    @ResponseBody
    public ResultVO save(@Valid CompetitionForm competitionForm, BindingResult buildingResult){
        if (buildingResult.hasErrors()){
            log.error("[添加比赛] 参数不正确,competitionForm={}"+competitionForm);
            throw new YmException(ResultEnum.PARAM_ERROR.getCode(),
                    buildingResult.getFieldError().getDefaultMessage());
        }
        Competition competition=new Competition();
        BeanUtils.copyProperties(competitionForm,competition);
        competition.setCreateTime(new Date());
        competition.setId(KeyUtil.genUniqueKey());
        Competition result=competitionService.save(competition);
        if (result!=null){
            log.info("[保存成功],competitionForm={}"+competitionForm);
            return ResultVOUtil.success();
        }else{
            log.error("[保存失败],competitionForm={}"+competitionForm);
            return ResultVOUtil.error(500,"error");
        }

    }

}
