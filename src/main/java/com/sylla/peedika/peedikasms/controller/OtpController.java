package com.sylla.peedika.peedikasms.controller;

import com.sylla.peedika.peedikasms.Exception.ServiceException;
import com.sylla.peedika.peedikasms.model.Users;
import com.sylla.peedika.peedikasms.model.repsonse.OtpResponse;
import com.sylla.peedika.peedikasms.service.UserService;
import com.sylla.peedika.peedikasms.service.impl.OtpGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OtpController {

    @Autowired
    UserService userService;

    @Autowired
    OtpGenerator otpGenerator;

    @GetMapping("/api/register")
    public ResponseEntity<OtpResponse> registerPhoneNumber(@RequestBody Users user) throws ServiceException {
        String status = userService.saveUser(user);
        OtpResponse otpResponse = new OtpResponse();
        if (status.equalsIgnoreCase("success")) {
            otpResponse.setOtpnumber(otpGenerator.generateOtpNumber());
        }
        return new ResponseEntity<OtpResponse>(otpResponse, HttpStatus.OK);
    }
}
