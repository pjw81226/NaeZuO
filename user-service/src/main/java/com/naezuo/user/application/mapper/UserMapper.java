package com.naezuo.user.application.mapper;

import com.naezuo.user.domain.User;
import com.naezuo.user.presentation.dto.UserSignUpRequest;
import com.naezuo.user.presentation.dto.UserSignUpResponse;

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

    public static UserSignUpResponse toResponse(User user) {
        return UserSignUpResponse.builder()
                .id(user.getId())
                .build();
    }
}
