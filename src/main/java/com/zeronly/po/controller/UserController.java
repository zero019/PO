package com.zeronly.po.controller;


import com.zeronly.po.model.ResResult;
import com.zeronly.po.model.common.LoginUser;
import com.zeronly.po.model.common.User;
import com.zeronly.po.model.purchase.PoContract;
import com.zeronly.po.security.MyUserSecurityService;
import com.zeronly.po.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zeronly
 * @since 2024-03-13
 */
@RestController
@RequestMapping("/po/user")
public class UserController {
    @Autowired
    private IUserService iUserService;
    @Autowired
    private MyUserSecurityService myUserSecurityService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @CrossOrigin
    public ResResult login(String username,String password) {
        ResResult resResult = iUserService.login(username, password);
        return resResult;
    }

    //增
    @PostMapping("/insert")
    public ResResult insert(@RequestBody List<User> users){
        boolean res = iUserService.saveBatch(users);
        if (res){
            return ResResult.ok();
        } else {
            return ResResult.fail();
        }
    }

    //删
    @PostMapping("/del")
    public ResResult del(@RequestBody List<String> usersIds){
        boolean res = iUserService.removeByIds(usersIds);
        if (res){
            return ResResult.ok();
        } else {
            return ResResult.fail();
        }
    }

    //改
    @PostMapping("/update")
    public ResResult update(@RequestBody List<User> users){
        boolean res = iUserService.saveOrUpdateBatch(users);
        if (res){
            return ResResult.ok();
        } else {
            return ResResult.fail();
        }
    }

    //查只能查
    @PostMapping("/read")
    public ResResult read(@RequestBody(required = false) Map<String, Object> query){
        if (CollectionUtils.isEmpty(query)){
            query = new HashMap<>();
        }
        List<User> res = iUserService.listByMap(query);

        return ResResult.ok(res);
    }
}
