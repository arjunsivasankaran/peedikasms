package com.sylla.peedika.peedikasms.service.impl;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.sylla.peedika.peedikasms.Exception.ServiceException;
import org.springframework.stereotype.Service;

import java.util.SplittableRandom;
import java.util.concurrent.TimeUnit;

@Service
public class OtpGenerator {
    private static final Integer EXPIRE_MINS = 15;

    private LoadingCache<String, String> otpCache;
    private final int otpLenght = 6;

    public OtpGenerator() {
        super();
        otpCache = CacheBuilder.newBuilder().
                expireAfterWrite(EXPIRE_MINS, TimeUnit.SECONDS).build(new CacheLoader<String, String>() {
            public String load(String key) {
                return "";
            }
        });
    }


    public String generateOtpNumber(String phoneNumber) {
        SplittableRandom splittableRandom = new SplittableRandom();
        StringBuilder stringBuilder = new StringBuilder(otpLenght);
        for (int i = 0; i < otpLenght; i++) {
            stringBuilder.append(splittableRandom.nextInt(0, 10));
        }
        otpCache.put(phoneNumber, stringBuilder.toString());
        return stringBuilder.toString();
    }

    public String getOtp(String key) throws ServiceException {
        try {
            return otpCache.get(key);
        } catch (Exception e) {
            throw new ServiceException("OTP Not Found");
        }
    }

    public void clearOTP(String key){
        otpCache.invalidate(key);
    }
}
