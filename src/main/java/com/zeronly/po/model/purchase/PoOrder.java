package com.zeronly.po.model.purchase;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.zeronly.po.model.base.BaseMain;
import lombok.Data;

/**
 * 采购订单主表
 * @author zeronly 2024/3/9
 */
@Data
@TableName("po_order")
public class PoOrder extends BaseMain {
    @TableId(type = IdType.ASSIGN_ID)
    @Column
    private String id;
    //采购订单单号
    @Column
    private String code;

    //供应商Id
    @Column
    private String suppilerId;
    //源单Id
    @Column
    private String sourceId;
    //源单code
    @Column
    private String sourceCode;
    //采购订单总金额
    @Column
    private String totalMoney;
}
