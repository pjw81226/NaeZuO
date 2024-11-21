package com.naezuo.user.infrastructure.repository;

import com.naezuo.user.application.interfaces.UserRepository;
import com.naezuo.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    private final JpaUserRepository jpaUserRepository;

    @Override
    public void save(User user) {
        jpaUserRepository.save(user);
    }

    @Override
    public Optional<User> findById(Long userId) {
        return jpaUserRepository.findById(userId);
    }
    @Override
    public Optional<User> login(String userId, String pw) {
        return jpaUserRepository.findByUserIdAndPw(userId, pw);
    }
}
