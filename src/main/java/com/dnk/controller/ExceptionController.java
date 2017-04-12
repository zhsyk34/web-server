package com.dnk.controller;

import com.dnk.exception.CustomException;
import com.dnk.exception.ResultEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionController {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionController.class);

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        logger.error("----------handle exception------------");
        logger.error("系统异常", e);
        if (e instanceof CustomException) {
            CustomException ce = (CustomException) e;
            return Result.error(ce);
        }

        return Result.from(ResultEnum.UNKNOWN, e.getMessage());
//        throw new RuntimeException(e);
    }
}
