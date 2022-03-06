package com.example.mall.domain.repo;

import com.example.mall.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User,Long> {

    User findUserByLoginName(String loginName);

    User save(User user);
}
