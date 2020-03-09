package com.sages.app.util;

import org.springframework.util.DigestUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wanyifan
 * @date 2020/3/4
 */
public class PasswordUtil {
    public static Boolean checkPwd(String password){
        return password.trim().equals(password);
    }
    public static String encryption(String password){
        String s = DigestUtils.md5DigestAsHex(password.getBytes());
        return s;
    }
}
