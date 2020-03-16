package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryCustomImpl implements UserRepositoryCustom {

    @Override
    public List<UserEntity> custom() {
        return null;
    }
}
