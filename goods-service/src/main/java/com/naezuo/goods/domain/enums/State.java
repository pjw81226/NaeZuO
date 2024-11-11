package com.naezuo.goods.domain.enums;

import lombok.Getter;

@Getter
public enum State {
    ING("펀딩중"),
    END("펀딩종료"),
    ;

    private final String description;

    State(String description) {
        this.description = description;
    }
}
