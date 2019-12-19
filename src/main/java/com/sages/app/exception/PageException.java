package com.sages.app.exception;

import com.sages.app.constant.enums.Status;
import lombok.Getter;
/**
 * <p>
 * 页面异常
 * @author wanyifan
 * @date 2019/12/19 14:51
 */
@Getter
public class PageException extends BaseException {

	public PageException(Status status) {
		super(status);
	}

	public PageException(Integer code, String message) {
		super(code, message);
	}
}
