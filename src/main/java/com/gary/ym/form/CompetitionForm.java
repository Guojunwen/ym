package com.gary.ym.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;

@Data
public class CompetitionForm {
    @NotEmpty(message="")
    private String title;
    @NotEmpty(message="")
    private Date matchTime;
    @NotEmpty(message="")
    private Date startRegistrationTime;
    @NotEmpty(message="")
    private Date endRegistrationTime;
    @NotEmpty(message="")
    private Integer limitQuantity;
    private String remark;
}
