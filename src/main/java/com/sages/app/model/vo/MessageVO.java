package com.sages.app.model.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wanyifan
 * @date 2020/3/4
 */
@Data
@NoArgsConstructor
public class MessageVO {
    private Boolean status;
    private String message;
    private Object data;

    public MessageVO(Boolean status) {
        this.status = status;
        this.message = "";
        this.data = null;
    }

    public MessageVO(Boolean status, String message) {
        this.status = status;
        this.message = message;
        this.data = null;
    }

    public MessageVO(Boolean status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static MessageVO success(){
        return new MessageVO(true,"操作成功");
    }

    public static MessageVO successUrl(Object url){
        return new MessageVO(true,"操作成功",url);
    }

    public static MessageVO success(String message){
        return new MessageVO(true,message);
    }

    public static MessageVO success(String message,Object data){
        return new MessageVO(true,message,data);
    }

    public static MessageVO fail(){
        return new MessageVO(false,"操作失败");
    }

    public static MessageVO fail(String msg){
        return new MessageVO(false,msg);
    }

    public static MessageVO of(Boolean status){
        return new MessageVO(status);
    }
}
