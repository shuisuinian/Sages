package com.sages.app.exception;

import com.sages.app.constant.enums.Status;
import lombok.Getter;

/**
 * @author wanyifan
 * @date 2020/3/21 10:04 下午
 * @version 1.0
 */

@Getter
public class TokenException extends BaseException {

    public TokenException(Status status) {
        super(status);
    }

    public TokenException(Integer code, String message) {
        super(code, message);
    }
}
