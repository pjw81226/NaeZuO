package com.naezuo.user.application.interfaces;

import com.naezuo.user.domain.User;

import java.util.Optional;

public interface UserRepository {
    void save(User user);

    Optional<User> findById(Long userId);
    Optional<User> login(String userId, String pw);

}
