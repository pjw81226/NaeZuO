package com.naezuo.user.presentation.dto;

import com.naezuo.user.domain.enums.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class UserSignInResponse {
    private Long id;
    private Role role;
}
