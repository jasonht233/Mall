package com.example.mall.api;

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
            return new Result(400,"Failure");
        }

        String registerResult = this.userservice.register(param.getLoginName(), param.getPassword());


        if(ServiceResultEnum.SUCCESS.getResult().equals(registerResult)) {
            return resultgenerator.genSuccessResult();
        }

        return resultgenerator.genErrorResult( 400 ,ServiceResultEnum.ERROR.getResult());
    }
}
