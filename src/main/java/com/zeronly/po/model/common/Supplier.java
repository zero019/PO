package com.zeronly.po.model.common;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zeronly.po.model.base.Base;
import lombok.Data;

import javax.persistence.Column;
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
    @Column
    private String name; // 公司名称
    @Column
    private String address; // 注册地址
    @Column
    private String type; // 公司类型
    @Column
    private String regNumber; // 工商注册号
    @Column
    private String phone; //公司电话
    @Column
    private String email; //联系公司邮箱
    @Column
    private String contactName; //财务联系人姓名
}
