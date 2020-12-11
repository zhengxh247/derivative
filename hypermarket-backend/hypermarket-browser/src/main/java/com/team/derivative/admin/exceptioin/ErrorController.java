package com.team.derivative.admin.exceptioin;

import io.swagger.annotations.Api;
import org.springframework.boot.autoconfigure.web.BasicErrorController;
import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhengxh
 */
@RestController
@Api(value = "filter错误处理", description = "filter错误处理")
public class ErrorController extends BasicErrorController {

    public ErrorController() {
        super(new DefaultErrorAttributes(), new ErrorProperties());
    }

    @Override
    @RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
        Map<String, Object> body = getErrorAttributes(request, isIncludeStackTrace(request, MediaType.ALL));
//        HttpStatus status = getStatus(request);
        // 获取错误信息
        Object message = body.get("message");
        System.out.println(body);
        System.out.println(message);
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", "1000404");
        map.put("message",message);
        return new ResponseEntity<>(map, HttpStatus.valueOf(200));
    }

    @Override
    public String getErrorPath() {
        return "error/error";
    }

}