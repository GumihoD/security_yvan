package com.yvan.security.repository;

import com.yvan.security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by yvan on 16/5/3.
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
