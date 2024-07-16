package com.m44rk0.forumhub.repository;

import com.m44rk0.forumhub.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, Long> {

    UserDetails findByEmail(String email);

}
