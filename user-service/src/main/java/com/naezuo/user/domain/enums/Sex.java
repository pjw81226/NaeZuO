package com.naezuo.user.domain.enums;

import lombok.Getter;
import org.antlr.v4.runtime.misc.NotNull;

@Getter
public enum Sex {
    W("여성"),
    M("남성"),
    ;

    private final String description;
    Sex(String description) { this.description = description; }

    @Override
    public String toString() {
        return name();
    }
}
