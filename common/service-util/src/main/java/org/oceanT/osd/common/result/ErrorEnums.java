package org.oceanT.osd.common.result;

/**
 * 错误类型的枚举
 *
 */
//在开发的时候可以进行添加枚举
public enum ErrorEnums {

    //-2为可以捕获的错误
    SYSTEM_ERROR(-3,"系统通用错误异常,请联系管理员"),
    SYSTEM_BUSY(-1,"系统繁忙，请稍后再试！"),
    NO_PERMISSION(401,"权限不足！"),
    NO_AUTH(403,"认证失败！")
    ;

    private Integer code;
    private String msg;

    ErrorEnums(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode(){
        return code;
    }

    public String getMsg(){
        return msg;
    }
}
