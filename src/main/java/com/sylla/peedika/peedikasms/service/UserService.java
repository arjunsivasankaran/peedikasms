package com.sylla.peedika.peedikasms.service;

import com.sylla.peedika.peedikasms.Exception.ServiceException;
import com.sylla.peedika.peedikasms.model.Users;

public interface UserService {
    public String saveUser(Users user) throws ServiceException;
}
