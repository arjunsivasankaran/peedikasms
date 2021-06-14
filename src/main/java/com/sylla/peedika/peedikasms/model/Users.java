package com.sylla.peedika.peedikasms.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "USERS")
@Table(name = "USERS")
public class Users {
    @Id
    @Column(name = "PHONENUMBER")
    @JsonProperty("phonenumber")
    private String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
