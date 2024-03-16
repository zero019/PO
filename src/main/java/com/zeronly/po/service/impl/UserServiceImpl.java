package com.zeronly.po.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zeronly.po.conf.JwtUtil;
import com.zeronly.po.conf.RedisCache;
import com.zeronly.po.model.ResResult;
import com.zeronly.po.model.common.LoginUser;
import com.zeronly.po.model.common.User;
import com.zeronly.po.mapper.UserMapper;
import com.zeronly.po.security.MyUserSecurityService;
import com.zeronly.po.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

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
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RedisCache redisCache;

    @Override
    public ResResult login(LoginUser user) {
        return ResResult.ok();
    }

    @Override
    public ResResult login(String username, String password) {
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("username", username);
//        map.put("password", password);
//
//        List<User> res = this.listByMap(map);
//        if (CollectionUtils.isEmpty(res)){
//            return ResResult.fail();
//        }

        // 使用Authentication的实现类
        Authentication authentication = new UsernamePasswordAuthenticationToken(username, password);
        Authentication authenticate = authenticationManager.authenticate(authentication);
        if (Objects.isNull(authenticate)) { // 说明输入错误
            throw new RuntimeException("用户名或密码错误");
        }
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        //此处隐藏密码
        loginUser.getUser().setPassword("");


        String userId = loginUser.getUser().getId() + "";

        String jwt = JwtUtil.createJWT(userId);
        redisCache.setCacheObject("poLogin:" + userId, loginUser);

        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(loginUser);
        jsonObject.put("token", jwt);


        return ResResult.ok(jsonObject);
    }
}
