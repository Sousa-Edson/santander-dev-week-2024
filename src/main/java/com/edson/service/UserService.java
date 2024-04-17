package com.edson.service;

import com.edson.domain.model.User;

public interface UserService  {

    User findById(Long id);

    User create(User useToCreate);


}