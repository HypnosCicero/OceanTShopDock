package org.oceanT.osd.common.result;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用于前后端数据交互的类
 * @param <T> 用于data的类型实例
 */
@Data
public class ResultModel<T> {

    @ApiModelProperty("响应码")
    private Integer code;

    @ApiModelProperty("响应信息")
    private String msg;

    @ApiModelProperty("响应数据")
    private T data;

    //通过设置private权限，让外部无法直接进行使用对象。
    private ResultModel() {

    }

    /**
     * 通用的制造方法
     * @param code 响应码
     * @param msg 响应信息
     * @param data 响应数据
     * @return 返回主体为ResultModel
     * @param <T> 表示任意类型
     */
    private static<T> ResultModel<T> build(Integer code,String msg,T data) {
        ResultModel<T> resultModel = new ResultModel<>();

        if(data != null) {
            resultModel.setData(data);
        }

        resultModel.setCode(code);
        resultModel.setMsg(msg);

        return resultModel;
    }

    /**
     * 通用成功返回方法
     * @param data 成功返回的数据
     * @return 返回对象为ResultModel
     * @param <T> 表示任意类型
     */
    public static<T> ResultModel<T> success(T data) {

        return build(200,"操作成功",data);
    }

    /**
     * 通用错误返回方法
     * @param errorEnums 错误的枚举类
     * @param data 错误时需要返回前端的数据。
     * @return 返回对象为ResultModel
     * @param <T> 表示任意类型
     */
    public static<T> ResultModel<T> filed(ErrorEnums errorEnums,T data) {

        return build(errorEnums.getCode(), errorEnums.getMsg(), data);
    }

    /**
     * 常用的错误返回方法
     * @param errorEnums 错误的枚举类
     * @return 返回对象为ResultModel
     * @param <T> 表示任意类型
     */
    public static<T> ResultModel<T> filed(ErrorEnums errorEnums){
        return filed(errorEnums,null);
    }
}
