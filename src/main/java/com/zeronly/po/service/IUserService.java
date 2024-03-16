package com.zeronly.po.service;

import com.zeronly.po.model.ResResult;
import com.zeronly.po.model.common.LoginUser;
import com.zeronly.po.model.common.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zeronly
 * @since 2024-03-13
 */
public interface IUserService extends IService<User> {

    public ResResult login(LoginUser user);

    public ResResult login(String username, String password);
}
