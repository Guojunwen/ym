package com.gary.ym.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Person {

    @Id
    private String id;
    private String name;//QQ昵称
    private String qq;
    private String battleId;//战网Id
    private Date createTime;

    private String level;//段位

    private Integer mmr;//MMR

}
