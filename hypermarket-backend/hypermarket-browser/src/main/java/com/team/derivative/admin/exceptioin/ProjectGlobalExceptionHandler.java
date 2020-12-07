package com.team.derivative.admin.exceptioin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zhengxh
 */
@ControllerAdvice
public class ProjectGlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(ProjectGlobalExceptionHandler.class);

    /**
     * 处理自定义的业务异常
     *
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = ServiceException.class)
    @ResponseBody
    public ResultBody pipeExceptionHandler(HttpServletRequest req, ServiceException e) {
        logger.error("发生业务异常！原因是：{}", e.getErrMessage());
        return ResultBody.error(e.getErrCode(), e.getErrMessage());
    }

    /**
     * 处理空指针的异常
     *
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = NullPointerException.class)
    @ResponseBody
    public ResultBody exceptionHandler(HttpServletRequest req, NullPointerException e) {
        logger.error("发生空指针异常！原因是:", e);
        return ResultBody.error(CommonEnum.BODY_NOT_MATCH);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public ResultBody MethodArgumentNotValidHandler(HttpServletRequest req, MethodArgumentNotValidException e) {
        //解析原错误信息，封装后返回，此处返回非法的字段名称，错误信息
        ResultBody resultBody = new ResultBody();
        for (FieldError error : e.getBindingResult().getFieldErrors()) {
            resultBody.setCode("1000400");
            resultBody.setMessage(error.getDefaultMessage() + ":" + error.getField());
        }
        return resultBody;
    }

    /**
     * 处理其他异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value =Exception.class)
    @ResponseBody
    public ResultBody exceptionHandler(HttpServletRequest req, Exception e){
        logger.error("未知异常！原因是:",e);
        return ResultBody.error(CommonEnum.INTERNAL_SERVER_ERROR);
    }
}