package com.zeronly.po.security;

import com.zeronly.po.conf.JwtUtil;
import com.zeronly.po.conf.RedisCache;
import com.zeronly.po.model.common.LoginUser;
import com.zeronly.po.service.IUserService;
import io.jsonwebtoken.Claims;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    private RedisCache redisCache;
    @Autowired
    private IUserService iUserService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //我们先拿到请求头中的token
        String token = request.getHeader("token");
        if(token == null){
            //说明没有携带token 那么直接放行 之后的过滤器肯定会报错，那么就说明用户没有登录
            filterChain.doFilter(request,response);
            return;
        }
        //解析token
        String userid;
        try {
            Claims claims = JwtUtil.parseJWT(token);
            userid  = claims.getSubject();
        } catch (Exception e) {
            e.printStackTrace();
            //就说明token失效了 或者是token无效
            throw new RuntimeException("token无效");
        }
        //从redis中拿到用户的信息，给SecurityContextHolder设置上下文
//        LoginUser loginUser = JSON.parseObject(JSON.toJSON(obj).toString(), LoginUser.class);
        
        LoginUser loginUser = redisCache.getCacheObject("poLogin:" + userid);
        if(Objects.isNull(loginUser)){
            throw new RuntimeException("用户未登录");
        }
        //存入SecurityContextHolder上下文当中  注意 这里必须得使用三个参数的authentication
        //第三个参数为授权 也就是用户是啥身份 先不管
//        List<String> list = new ArrayList<String>();
//		for( GrantedAuthority i : loginUser.getAuthorities()) {
//			list.add(i.getAuthority());
//		}
//		loginUser.setPermission(list);
        Authentication authentication = new UsernamePasswordAuthenticationToken(loginUser,null,loginUser.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        //放行
        filterChain.doFilter(request,response); //那么就正常的请求接口去啦！！！
    }
}

