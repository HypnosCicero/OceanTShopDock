package org.oceanT.osd.common.exception;

import lombok.Data;
import org.oceanT.osd.common.result.ErrorEnums;

/**
 * 自定义异常OceanShopDockException
 */
@Data
public class OsdException extends RuntimeException{

    /**
     * 初始code为-2,与ErrorEnums中所规定一样
     */
    private Integer code = -2;

    /**
     * 常规模式生成对象，默认异常信息
     */
    public OsdException(){
        super("未检测异常，请联系管理员");
    }

    /**
     * 需要传递额外的异常的信息的方法
     * @param msg 其他异常信息
     */
    public OsdException(String msg){
        super(msg);
    }

    /**
     * 传递相关的ErrorEnums的自定义异常
     * @param errorEnums 传入的ErrorEnums。
     */
    public OsdException(ErrorEnums errorEnums){
        super(errorEnums.getMsg());
        this.code = errorEnums.getCode();
    }
}
