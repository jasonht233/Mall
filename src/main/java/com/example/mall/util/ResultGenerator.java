package com.example.mall.util;


import com.example.mall.api.vo.Result;
import com.sun.xml.bind.v2.TODO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class ResultGenerator {
    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";
    private static final String DEFAULT_FAIL_MESSAGE = "FAIL";
    private static final int RESULT_CODE_SUCCESS = 200;
    private static final int RESULT_CODE_SERVER_ERROR = 500;

    public Result genSuccessResult() {
        return generateResult(RESULT_CODE_SUCCESS,DEFAULT_SUCCESS_MESSAGE,null);
    }

    public Result genSuccessResult(String message) {
        return generateResult(RESULT_CODE_SUCCESS,message,null);
    }

    public Result genSuccessResult(Object data) {
        return generateResult(RESULT_CODE_SUCCESS,DEFAULT_SUCCESS_MESSAGE,null);
    }

    public Result genFailResult(String message) {
        if (StringUtils.isBlank(message)) {
            return generateResult(RESULT_CODE_SERVER_ERROR,DEFAULT_FAIL_MESSAGE,null);
        } else {
            return generateResult(RESULT_CODE_SERVER_ERROR,message,null);
        }
    }

    public Result genErrorResult(int code, String message) {

        return generateResult(code,message,null);
    }


    private Result generateResult(int code, String message, Object data) {
        return new Result(code,message,data);
    }

    //todo: Finish the video at 42:59. Please continue
}
