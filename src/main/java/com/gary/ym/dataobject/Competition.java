package com.gary.ym.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Competition {
    @Id
    private String id;
    private String title;//比赛标题
    private Date matchTime;//比赛时间
    private Date startRegistrationTime;//报名开始时间
    private Date endRegistrationTime;//报名结束时间
    private Integer limitQuantity;//人数上限
    private Date createTime;//比赛创建时间
    private String remark;//说明
}
