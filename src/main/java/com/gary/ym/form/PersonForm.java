package com.gary.ym.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;

/**
 * Created by gary on 2017/12/18.
 */
@Data
public class PersonForm {

    @NotEmpty(message="QQ昵称必填")
    private String name;//QQ昵称
    @NotEmpty(message="QQ必填")
    private String qq;
    @NotEmpty(message="战网Id必填")
    private String battleId;//战网Id
    @NotEmpty(message="段位必填")
    private String level;//段位
}
