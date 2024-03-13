package com.zeronly.po.model.enums;

/**
 * @author zeronly 2024/3/12
 */
public enum statesEnum {
    OK("1"),
    NO("0"),

    isDel("3"),
    notDel("4");

    private final String code;

    statesEnum(String code){
        this.code = code;
    }

    public String getAuth() {
        return code;
    }
}
