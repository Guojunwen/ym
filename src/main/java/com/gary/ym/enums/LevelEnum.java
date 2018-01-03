package com.gary.ym.enums;

import lombok.Getter;

/**
 * 天梯等级
 * Created by Guo on 2018/1/3.
 */
@Getter
public enum LevelEnum {

    BRONZE("A", "青铜"),
    silver("B", "白银"),
    gold("C", "黄金"),
    platinum("D", "白金"),
    diamond("E", "钻石"),
    master("F", "大师"),
    guru("G", "宗师"),;

    private String code;

    private String msg;

    LevelEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
