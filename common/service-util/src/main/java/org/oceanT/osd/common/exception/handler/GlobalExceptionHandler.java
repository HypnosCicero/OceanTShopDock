package org.oceanT.osd.common.exception.handler;

import lombok.extern.slf4j.Slf4j;
import org.oceanT.osd.common.result.ErrorEnums;
import org.oceanT.osd.common.result.ResultModel;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 通用异常处理类
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResultModel error(Exception e){
      log.error(e.getMessage());
      e.printStackTrace();
      Class<ResultModel> resultModelClass = ResultModel.class;

        ResultModel resultModel = null;
        try {
            Method buildMethod = resultModelClass.getDeclaredMethod("build", Integer.class, String.class, Object.class);
            buildMethod.setAccessible(true);
            resultModel = (ResultModel) buildMethod.invoke(null, -2, "系统级错误：" + e.getMessage(), null);

        } catch (NoSuchMethodException ex) {
            ex.printStackTrace();
            resultModel = ResultModel.filed(ErrorEnums.SYSTEM_ERROR);

        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
            resultModel = ResultModel.filed(ErrorEnums.SYSTEM_ERROR);

        } catch (InvocationTargetException ex) {
            ex.printStackTrace();
            resultModel = ResultModel.filed(ErrorEnums.SYSTEM_ERROR);

        } finally {
            return resultModel;
        }
    }
}
