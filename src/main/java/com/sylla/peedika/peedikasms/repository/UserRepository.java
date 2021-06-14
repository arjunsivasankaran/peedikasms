package com.sylla.peedika.peedikasms.repository;

import com.sylla.peedika.peedikasms.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,String> {

    @Query("SELECT u FROM USERS u WHERE u.phoneNumber = ?1")
    Users getUserByPhoneNumber(String phoneNumber);
}
