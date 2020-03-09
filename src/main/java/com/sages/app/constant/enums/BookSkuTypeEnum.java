package com.sages.app.constant.enums;

/**
 * @author wanyifan
 * @date 2020/3/6
 */
public enum BookSkuTypeEnum {
    /**
     * 管理员
     */
    ADMIN(0,"实体书"),
    /**
     * 用户
     */
    USER(1,"电子书"),

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
        for (BookSkuTypeEnum value : BookSkuTypeEnum.values()) {
            if (value.getCode().equals(code)) {
                return value.getName();
            }
        }
        return "";
    }

    BookSkuTypeEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }
}
