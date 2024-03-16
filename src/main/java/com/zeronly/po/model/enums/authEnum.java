package com.zeronly.po.model.enums;

/**
 * 权限枚举类
 * @author zeronly 2024/3/12
 */

public enum authEnum {
    ROLE_ADMIN("001"),
    ROLE_APPLY("002"),
    ROLE_CONTRACT("003"),
    ROLE_INQUERY("004"),
    ROLE_ORDER("005"),
    ROLE_WAREHOUSE("006"),

    PURCHASE("100");

    private final String code;

    authEnum(String code) {
        this.code = code;
    }

    public String getAuth() {
        return code;
    }
}
