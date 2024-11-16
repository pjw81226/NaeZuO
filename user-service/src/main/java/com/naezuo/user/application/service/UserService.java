package com.naezuo.user.application.service;

import com.naezuo.user.application.interfaces.UserRepository;
import com.naezuo.user.application.mapper.UserMapper;
import com.naezuo.user.presentation.dto.UserLoginRequest;
import com.naezuo.user.presentation.dto.UserRequest;
import com.naezuo.user.presentation.dto.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void signUp(UserRequest userRequest){
        userRepository.save(UserMapper.toDomain(userRequest));
    }

    public Optional<UserResponse> signIn(UserLoginRequest userLoginRequest){
        return userRepository.login(userLoginRequest.getUserId(), userLoginRequest.getPw())
                .map(UserMapper::toResponse);
    }
}
