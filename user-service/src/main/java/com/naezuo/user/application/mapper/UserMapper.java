package com.naezuo.user.application.mapper;

import com.naezuo.user.domain.User;
import com.naezuo.user.presentation.dto.UserResponse;
import com.naezuo.user.presentation.dto.UserSignUpRequest;
import com.naezuo.user.presentation.dto.UserSignInResponse;

public class UserMapper {

    public static User toDomain(UserSignUpRequest userSignUpRequest){
        return User.builder()
                .userId(userSignUpRequest.getUserId())
                .pw(userSignUpRequest.getPw())
                .age(userSignUpRequest.getAge())
                .sex(userSignUpRequest.getSex())
                .name(userSignUpRequest.getName())
                .role(userSignUpRequest.getRole())
                .build();
    }

    public static UserSignInResponse toResponse(User user) {
        return UserSignInResponse.builder()
                .id(user.getId())
                .role(user.getRole())
                .build();
    }

    public static UserResponse toUserResponse(User user){
        return UserResponse.builder()
                .id(user.getId())
                .userId(user.getUserId())
                .name(user.getName())
                .age(user.getAge())
                .pw(user.getPw())
                .sex(user.getSex())
                .role(user.getRole())
                .build();
    }
}
