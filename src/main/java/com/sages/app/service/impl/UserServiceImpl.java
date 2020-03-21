package com.sages.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;
import com.sages.app.constant.enums.UserTypeEnum;
import com.sages.app.model.entity.Role;
import com.sages.app.model.entity.User;
import com.sages.app.mapper.UserMapper;
import com.sages.app.model.vo.PageTable;
import com.sages.app.service.IRoleService;
import com.sages.app.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sages.app.util.PasswordUtil;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wanyifan
 * @since 2020-03-03
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    private final IRoleService roleService;

    public UserServiceImpl(IRoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public PageTable listUserByCondition(Integer id, String keyword, Integer page, Integer size, Integer userType) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        if (id!=0){
            wrapper.eq("id",id);
        }else {
            wrapper.inSql("id","select user_id from role where type = "+userType)
                    .and(i->i.like("account",keyword).or().like("nickname",keyword));
        }
        PageMethod.startPage(page,size);
        List<User> list = list(wrapper);
        PageInfo<User> pageInfo = new PageInfo<>(list);
        return new PageTable(pageInfo);
    }

    @Override
    public User adminUserLogin(String account, String password) {
        if (!PasswordUtil.checkPwd(password)) {
            return null;
        }
        String pwd = PasswordUtil.encryption(password);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("account",account).eq("password",pwd);
        return getOne(wrapper);
    }

    @Override
    public boolean saveOrUpdateUser(User user) {
        String openId = user.getOpenId();
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("open_id",openId);
        User one = getOne(wrapper);
        boolean res;
        if (one==null){
            // 保存
            res = save(user);
            roleService.save(new Role(user.getId(), UserTypeEnum.USER.getCode())) ;
        }else {
            // 更新
            one.updateByOtherUser(user);
            res = updateById(one);
        }
        return res;
    }
}
