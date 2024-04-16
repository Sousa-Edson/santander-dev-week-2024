package com.edson.service.impl;

import com.edson.domain.model.User;
import com.edson.domain.repository.UserRepository;
import com.edson.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User finddyId(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User useToCreate) {
        if(useToCreate.getId() != null && userRepository.existsByAccountNumber(useToCreate.getAccount().getNumber())){
            throw new IllegalArgumentException("Este número de conta já existe.");
        }
        return userRepository.save(useToCreate);
    }
}
