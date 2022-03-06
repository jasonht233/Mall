package com.example.mall.service.impl;

import com.example.mall.common.ServiceResultEnum;
import com.example.mall.domain.User;
import com.example.mall.domain.repo.UserRepo;
import com.example.mall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepo userrepo;

    @Autowired
    public UserServiceImpl(UserRepo userrepo) {
        this.userrepo = userrepo;
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
}
