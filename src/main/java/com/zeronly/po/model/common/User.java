package com.zeronly.po.model.common;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zeronly.po.model.base.Base;
import lombok.Data;

/**
 * 登录用户
 * @author zeronly 2024/3/9
 */
@Data
@TableName("user")
public class User extends Base {
    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    private String username;

    private String password;

    //用户权限，全都写在一个字段里面
    //权限通过英文下的;实现，若该字段无内容则默认admin权限
    //如：apply;contract;
    private String authorities;

    //所属部门
    private String deptId;
}
