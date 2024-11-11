package com.naezuo.user.domain.enums;

import lombok.Getter;

@Getter
public enum Role {
    NORMAL("일반"),
    INFLUENCER("인플루언서"),
    ;
    
    private final String description;
    Role(String description) { this.description = description; }
}
