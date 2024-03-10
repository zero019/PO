package com.zeronly.po.model.base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 供应商
 * @author zeronly 2024/3/6
 */
@Data
@TableName("supplier")
public class Supplier extends Base {
    //使用的id生成策略是雪花算法递增
    @TableId(type = IdType.ASSIGN_ID)
    private String id;
    private String name; // 公司名称
    private String address; // 注册地址
    private String type; // 公司类型
    private String regNumber; // 工商注册号
    private String phone; //公司电话
    private String email; //联系公司邮箱
    private String contact; //财务联系人姓名
}
