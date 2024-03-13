package com.zeronly.po.service.impl;

import com.zeronly.po.model.common.User;
import com.zeronly.po.mapper.UserMapper;
import com.zeronly.po.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zeronly
 * @since 2024-03-13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
