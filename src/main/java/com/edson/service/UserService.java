package com.edson.service;

import com.edson.domain.model.User;

public interface UserService  {

    User finddyId(Long id);

    User create(User useToCreate);


}