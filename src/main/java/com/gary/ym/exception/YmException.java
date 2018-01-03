package com.gary.ym.exception;

import com.gary.ym.enums.ResultEnum;

/**
 * Created by Guo on 2018/1/3.
 */
public class YmException extends RuntimeException{
    private Integer code;

    public YmException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code=resultEnum.getCode();
    }

    public YmException (Integer code,String message){
        super(message);
        this.code=code;
    }
}
