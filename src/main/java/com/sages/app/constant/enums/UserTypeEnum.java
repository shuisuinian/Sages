package com.sages.app.constant.enums;

/**
 * @author wanyifan
 * @date 2020/3/4
 */
public enum UserTypeEnum {
    /**
     * 管理员
     */
    ADMIN(0,"管理员"),
    /**
     * 用户
     */
    USER(1,"用户"),

    ;
    Integer code;
    String name;

    public Integer getCode(){
        return this.code;
    }

    public String getName(){
        return this.name;
    }

    public static String getName(Integer code){
        for (UserTypeEnum value : UserTypeEnum.values()) {
            if (value.getCode().equals(code)) {
                return value.getName();
            }
        }
        return "";
    }

    UserTypeEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }
}
