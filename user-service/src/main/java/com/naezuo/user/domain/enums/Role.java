package com.naezuo.user.domain.enums;

public enum UserType {
    NORMAL("일반"),
    INFLUENCER("인플루언서"),
    ;
    
    private final String description;
    UserType(String description) { this.description = description; }
}
