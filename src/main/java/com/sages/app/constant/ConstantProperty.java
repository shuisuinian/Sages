package com.sages.app.constant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 配置文件信息读取类
 * @author wanyifan
 * @date 2019/12/19 9:57
 */
@Component
public class ConstantProperty {

    /**
     * 自定义错误堆栈信息数
     */
    public static Integer errorLogStackNumber;
    @Value("${constant.error-log-stack-number}")
    public void setErrorLogStackNumber(Integer errorLogStackNumber) {
        ConstantProperty.errorLogStackNumber = errorLogStackNumber;
    }

    /**
     * 文件本地根路径
     */
    public static String localPath;
    @Value("${server.resource}")
    public void setLocalPath(String localPath) {
        ConstantProperty.localPath = localPath;
    }

    public static String localPicPath;
    @Value("${picture.path}")
    public void setLocalPicPath(String localPicPath) {
        ConstantProperty.localPicPath = localPicPath;
    }

    public static String localBookPicPath;
    @Value("${picture.book}")
    public void setLocalBookPicPath(String localBookPicPath) {
        ConstantProperty.localBookPicPath = localBookPicPath;
    }

    public static String localCommentPicPath;
    @Value("${picture.comment}")
    public void setLocalCommentPicPath(String localCommentPicPath) {
        ConstantProperty.localCommentPicPath = localCommentPicPath;
    }

    /**
     * 部署ip
     */
    public static String ServiceIp;
    @Value("${server.ip}")
    public void setServiceIp(String serviceIp) {
        ServiceIp = serviceIp;
    }

    /**
     * 部署的url
     */
    public static String ServiceAddressUrl;
    @Value("${server.address.url}")
    public void setServiceAddressUrl(String serviceAddressUrl) {
        ServiceAddressUrl = serviceAddressUrl;
    }


}
