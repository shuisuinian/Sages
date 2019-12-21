package com.sages.app.constant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 配置文件信息读取类
 * @author wanyifan
 * @date 2019/12/19 9:57
 */
@Component
public class ConstantProperty {

    public static Integer errorLogStackNumber;
    @Value("${constant.error-log-stack-number}")
    public void setErrorLogStackNumber(Integer errorLogStackNumber) {
        ConstantProperty.errorLogStackNumber = errorLogStackNumber;
    }
}
