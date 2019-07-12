package com.demoproject.userdemo.dao.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demoproject.userdemo.pojos.*;

public interface UserRepository extends JpaRepository<UserDetails, Integer> {

}
