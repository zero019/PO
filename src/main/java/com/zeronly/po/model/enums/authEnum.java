package com.zeronly.po.model.enums;

/**
 * 权限枚举类
 * @author zeronly 2024/3/12
 */

public enum authEnum {
    ADMIN("001"),
    APPLY("002"),
    CONTRACT("003"),
    INQUERY("004"),
    ORDER("005"),
    WAREHOUSE("006"),

    PURCHASE("100");

    private final String code;

    authEnum(String code) {
        this.code = code;
    }

    public String getAuth() {
        return code;
    }
}
