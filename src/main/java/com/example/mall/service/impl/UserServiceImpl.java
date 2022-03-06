package com.example.mall.service.impl;

import com.example.mall.api.vo.Result;
import com.example.mall.common.ServiceResultEnum;
import com.example.mall.domain.Token;
import com.example.mall.domain.User;
import com.example.mall.domain.repo.TokenRepo;
import com.example.mall.domain.repo.UserRepo;
import com.example.mall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    private UserRepo userrepo;
    private TokenRepo tokenrepo;

    @Autowired
    public UserServiceImpl(UserRepo userrepo, TokenRepo tokenrepo) {
        this.userrepo = userrepo;
        this.tokenrepo = tokenrepo;
    }


    @Override
    public String register(String loginName, String password) {
        if(userrepo.findUserByLoginName(loginName) != null) {
            return ServiceResultEnum.SAME_LOGIN_NAME_EXIST.getResult();
        }

        User userToReg = new User();
        userToReg.setLoginName(loginName);
        userToReg.setPassword(password);

        if(this.userrepo.save(userToReg) != null) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    @Override
    public String login(String loginName, String password) {
        User user = this.userrepo.findUserByLoginNameAndAndPassword(loginName, password);
        if(user == null ) {
            return ServiceResultEnum.USER_NULL_ERROR.getResult();
        }

        Token token = this.tokenrepo.findTokenByUserId(user.getId());
        if(token == null) {
            token = new Token();
            token.setUserId(user.getId());
        }

        Date now = new Date();
        Date expire = new Date(now.getTime()+2 * 24 * 3600 * 1000);

        token.setExpired(expire);
        token.setUpdated(now);
        token.setTokenString("12345678901234567890123456789012");

        if(this.tokenrepo.save(token) != null) {
            return token.getTokenString();
        }

        return ServiceResultEnum.LOGIN_ERROR.getResult();
    }

}
