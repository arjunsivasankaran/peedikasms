package com.sylla.peedika.peedikasms.service.impl;

import org.springframework.stereotype.Service;

import java.util.SplittableRandom;

@Service
public class OtpGenerator {
    private final int otpLenght = 6;

    public String generateOtpNumber() {
        SplittableRandom splittableRandom = new SplittableRandom();
        StringBuilder stringBuilder = new StringBuilder(otpLenght);
        for (int i = 0; i < otpLenght; i++) {
            stringBuilder.append(splittableRandom.nextInt(0, 10));
        }
        return stringBuilder.toString();

    }
}
