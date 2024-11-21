package com.naezuo.user.presentation.dto;

import com.naezuo.user.domain.enums.Role;
import com.naezuo.user.domain.enums.Sex;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class UserResponse {
    private Long id;
    private String userId;
    private String name;
    private Integer age;
    private String pw;
    private Sex sex;
    private Role role;

}
