package com.sages.app.exception;


import com.sages.app.model.enums.Status;
import lombok.Getter;
/**
 * <p>
 * JSON异常
 * @author wanyifan
 * @date 2019/12/19 14:51
 */

@Getter
public class JsonException extends BaseException {

	public JsonException(Status status) {
		super(status);
	}

	public JsonException(Integer code, String message) {
		super(code, message);
	}
}
