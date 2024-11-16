package com.naezuo.user.application.mapper;

import com.naezuo.user.domain.User;
import com.naezuo.user.presentation.dto.UserRequest;
import com.naezuo.user.presentation.dto.UserResponse;

public class UserMapper {

    public static User toDomain(UserRequest userRequest){
        return User.builder()
                .userId(userRequest.getUserId())
                .pw(userRequest.getPw())
                .age(userRequest.getAge())
                .sex(userRequest.getSex())
                .name(userRequest.getName())
                .role(userRequest.getRole())
                .build();
    }

    public static UserResponse toResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .build();
    }
}
