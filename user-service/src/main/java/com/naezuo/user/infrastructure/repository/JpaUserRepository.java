package com.naezuo.user.infrastructure.repository;

import com.naezuo.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaUserRepository extends JpaRepository<User, Long> {


    Optional<User> findByUserIdAndPw(String userId, String pw);
}
