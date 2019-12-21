package com.sages.app.handler;

import com.sages.app.constant.ConstantProperty;
import com.sages.app.constant.enums.Status;
import com.sages.app.model.vo.ApiResponse;
import com.sages.app.exception.JsonException;
import com.sages.app.exception.PageException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author wanyifan
 * @date 2019/12/19 14:51
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
	private static final String DEFAULT_ERROR_VIEW = "error";
	/**
	 * 统一 json 异常处理
	 *
	 * @param e JsonException
	 * @return 统一返回 json 格式
	 */
	@ExceptionHandler(value = JsonException.class)
	@ResponseBody
	public ApiResponse jsonErrorHandler(JsonException e) {
		StackTraceElement[] stackTrace = e.getStackTrace();
		StringBuilder sOut = new StringBuilder("【JsonException】:" + e.getMessage()+ "\r\n" + e.getClass().getName() + "\r\n");
		// 打印堆栈信息 前 x 条
		for (int i = 0; i< ConstantProperty.errorLogStackNumber ; i++) {
			sOut.append("\tat ").append(stackTrace[i]).append("\r\n");
		}
		log.error(sOut.toString());
		return ApiResponse.ofException(e);
	}

	/**
	 * 统一 页面 异常处理
	 *
	 * @param exception PageException
	 * @return 统一跳转到异常页面
	 */
	@ExceptionHandler(value = PageException.class)
	public ModelAndView pageErrorHandler(PageException exception) {
		log.error("【DemoPageException】:{}", exception.getMessage());
		ModelAndView view = new ModelAndView();
		view.addObject("message", exception.getMessage());
		view.setViewName(DEFAULT_ERROR_VIEW);
		return view;
	}

	/**
	 * 统一 json 异常处理
	 *
	 * @param e RuntimeException
	 * @return 统一返回 json 格式
	 */
	@ExceptionHandler(value = RuntimeException.class)
	@ResponseBody
	public ApiResponse jsonErrorHandler(RuntimeException e) {
		StackTraceElement[] stackTrace = e.getStackTrace();
		StringBuilder sOut = new StringBuilder("【RuntimeException】:" + e.getMessage()+ "\r\n" + e.getClass().getName() + "\r\n");
		// 打印堆栈信息 前 x 条
		for (int i = 0; i< ConstantProperty.errorLogStackNumber ; i++) {
			sOut.append("\tat ").append(stackTrace[i]).append("\r\n");
		}
		log.error(sOut.toString());
		return ApiResponse.ofStatus(Status.UNKNOWN_ERROR);
	}

}
