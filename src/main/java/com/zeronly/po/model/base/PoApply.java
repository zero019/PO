package com.zeronly.po.model.base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 采购申请主表
 * @author zeronly 2024/3/9
 */
@Data
@TableName("po_apply")
public class PoApply extends Base{
    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    //采购申请单号
    private String code;
    //申请日期
    private Date applyDate;
    //申请部门id
    private String deptId;
    //申请人id
    private String userId;
    //采购类型id
    private String poTypeId;
    //库存组织id
    private String poOrganId;
    //财务组织id
    private String acuId;
    //采购总金额
    private BigDecimal totalMoney;
    //收货地址
    private String address;
    //采购原因
    private String reason;
    //备注
    private String notes;



}
