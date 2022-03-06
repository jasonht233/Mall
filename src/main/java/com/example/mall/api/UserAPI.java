package com.example.mall.api;

import com.example.mall.common.Constants;
import org.apache.commons.lang3.StringUtils;
import com.example.mall.api.param.UserLoginParam;
import com.example.mall.api.param.UserRegisterParam;
import com.example.mall.api.vo.Result;
import com.example.mall.common.ServiceResultEnum;
import com.example.mall.service.UserService;
import com.example.mall.util.NumberUtil;
import com.example.mall.util.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class UserAPI {

    private NumberUtil numberutil;
    private ResultGenerator resultgenerator;
    private UserService userservice;

    @Autowired
    public UserAPI(NumberUtil numberUtil,ResultGenerator resultgenerator, UserService userservice)
    {
        this.numberutil = numberUtil;
        this.resultgenerator = resultgenerator;
        this.userservice = userservice;
    }

    @PostMapping("/user/register")
    public Result  register(@RequestBody @Valid UserRegisterParam param) {
        if(this.numberutil.isNotPhone(param.getLoginName())){
            return this.resultgenerator.genFailResult(ServiceResultEnum.LOGIN_NAME_IS_NOT_PHONE.getResult());
        }

        String registerResult = this.userservice.register(param.getLoginName(), param.getPassword());


        if(ServiceResultEnum.SUCCESS.getResult().equals(registerResult)) {
            return resultgenerator.genSuccessResult();
        }

        return resultgenerator.genErrorResult( 400 ,ServiceResultEnum.ERROR.getResult());
    }

    @PostMapping("/user/login")
    public Result login(@RequestBody @Valid UserLoginParam param) {
        if(this.numberutil.isNotPhone(param.getLoginName())){
            return this.resultgenerator.genFailResult(ServiceResultEnum.LOGIN_NAME_IS_NOT_PHONE.getResult());
        }

        String loginResult = this.userservice.login(param.getLoginName(), param.getPassword());

        if( (! StringUtils.isBlank(loginResult) ) && loginResult.length() == Constants.TOKEN_LENGTH ) {
            Result result = this.resultgenerator.genSuccessResult();
            result.setData(loginResult);
            return result;
        }

        return resultgenerator.genFailResult(loginResult);
    }

//    @PostMapping("/user/logout")
//    public Result logout(@RequestBody @Vaid)

//    TODO: Logout/GetUserUpdated
//    TODO: 1:16:03 Video
}
