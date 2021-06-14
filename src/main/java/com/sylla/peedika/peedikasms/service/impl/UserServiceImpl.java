package com.sylla.peedika.peedikasms.service.impl;

import com.sylla.peedika.peedikasms.Exception.ServiceException;
import com.sylla.peedika.peedikasms.model.Users;
import com.sylla.peedika.peedikasms.repository.UserRepository;
import com.sylla.peedika.peedikasms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public String saveUser(Users user) throws ServiceException {
        Optional<Users> rateEntity = Optional.ofNullable(userRepository.getUserByPhoneNumber(user.getPhoneNumber()));
        if(rateEntity.isEmpty()){
            userRepository.save(user);
        }
        return "Success";
    }
}
