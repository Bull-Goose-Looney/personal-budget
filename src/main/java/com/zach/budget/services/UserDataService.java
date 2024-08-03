package com.zach.budget.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zach.budget.entities.UserDataEntity;
import com.zach.budget.repositories.UserDataRepository;

@Service
public class UserDataService {

    @Autowired
    private UserDataRepository repo;

    //TODO this should return POJOs not Entites
    public List<UserDataEntity> findAll() {
        return repo.findAll();
    }

    public UserDataEntity save(UserDataEntity user) {
        return repo.save(user);
    }
}
