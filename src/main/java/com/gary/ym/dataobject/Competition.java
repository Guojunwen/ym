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
    private Date startTime;//比赛时间
    private Date createTime;//比赛创建时间
    private String remark;//说明
}
