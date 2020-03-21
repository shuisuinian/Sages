package com.sages.app.constant.enums;

import lombok.Getter;

/**
 * @author wanyifan
 * @date 2019/12/19 14:51
 */
@Getter
public enum Status {
	/**
	 * 操作成功
	 */
	OK(200, "操作成功"),
	/**
	 * 操作成功
	 */
	FAIL(404, "没有找到"),
	/**
	 * Unauthorized
	 */
	UNAUTHORIZED(401,"没有权限"),
	/**
	 * 文件转化异常
	 */
	TYPE_CASE_ERROR(401,"文件类型转化异常"),
	/**
	 * 未知异常
	 */
	UNKNOWN_ERROR(500, "服务器出错啦"),
	/**
	 * 请求超时
	 */
	CONNECTION_TIMEOUT(408,"请求超时"),
	;
	/**
	 * 状态码
	 */
	private Integer code;
	/**
	 * 内容
	 */
	private String message;

	Status(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
}
