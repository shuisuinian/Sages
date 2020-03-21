package com.sages.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sages.app.model.entity.User;
import com.sages.app.model.vo.PageTable;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author wanyifan
 * @since 2020-03-03
 */
public interface IUserService extends IService<User> {
    /**
     * 条件查询
     *
     * @param id       用户id
     * @param keyword  关键词  /nickname/account/
     * @param page     page
     * @param size     size
     * @param userType userType
     * @return
     */
    PageTable listUserByCondition(Integer id, String keyword, Integer page, Integer size, Integer userType);

    /**
     * 管理员登录接口
     *
     * @param account  账户
     * @param password 密码
     * @return true/false
     */
    User adminUserLogin(String account, String password);

    /**
     * 保存或者更新user
     *
     * @param user
     * @return
     */
    boolean saveOrUpdateUser(User user);
}
