package com.sages.app.exception;

import com.sages.app.model.enums.Status;
import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * @author wanyifan
 * @date 2019/12/19 14:51
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BaseException extends RuntimeException {
    private Integer code;
    private String message;

    public BaseException(Status status) {
        super(status.getMessage());
        this.code = status.getCode();
        this.message = status.getMessage();
    }

    public BaseException(Integer code, String message) {
//		super(message);
        this.code = code;
        this.message = message;
    }
}