package com.sylla.peedika.peedikasms.controller;

import antlr.StringUtils;
import com.sylla.peedika.peedikasms.Exception.InvalidOTPException;
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
            otpResponse.setOtpnumber(otpGenerator.generateOtpNumber(user.getPhoneNumber()));
        }
        return new ResponseEntity<OtpResponse>(otpResponse, HttpStatus.OK);
    }

    @RequestMapping("/api/validateotp")
    @ResponseBody
    public String validateOtp(@RequestParam("otpNumber") String otpNumber, @RequestBody Users user) throws InvalidOTPException {
        String serverOtp = "";
        if (!otpNumber.isEmpty() || otpNumber != null)
            serverOtp = otpGenerator.getOtp(user.getPhoneNumber());
        if (otpNumber.equalsIgnoreCase(serverOtp)) {
            otpGenerator.clearOTP(user.getPhoneNumber());
            return "Success";
        } else {
            throw new ServiceException("Invalid OTP/ Otp Expired");
        }

    }


}
