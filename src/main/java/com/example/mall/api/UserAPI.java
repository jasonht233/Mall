package com.example.mall.api;

import com.example.mall.api.param.UserRegisterParam;
import com.example.mall.api.vo.Result;
import com.example.mall.util.NumberUtil;
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

    @Autowired
    public UserAPI(NumberUtil numberUtil)
    {
        this.numberutil = numberUtil;
    }

    @PostMapping("/user/register")
    public Result  register(@RequestBody @Valid UserRegisterParam param) {
        if(this.numberutil.isNotPhone(param.getLoginName())){
            return new Result(400,"Failure");
        }

        return new Result<String>(233,"Success");
    }
}
