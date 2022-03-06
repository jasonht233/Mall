package com.example.mall.domain.repo;

import com.example.mall.domain.Token;
import org.springframework.data.repository.CrudRepository;

public interface TokenRepo extends CrudRepository<Token,Long> {

    Token save(Token token);

    Token findTokenByUserId(Long userId);


}
