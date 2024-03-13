package com.zeronly.po.model.purchase;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zeronly.po.model.base.BaseMain;
import lombok.Data;

import java.util.Date;

/**
 * 采购合同
 * @author zeronly 2024/3/9
 */
@Data
@TableName("po_contract")
public class PoContract extends BaseMain {
    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    //供应商Id
    private Integer supplierId;
    //合同类型
    private String contractType;
    //开始期
    private Date validateDateBegin;
    //结束期
    private Date validateDateEnd;
    //合同执行状态
    private String status;
    //合同金额
    private String contractMoney;
    //选定后总金额
    private String totalMoney;

    //源单Id
    private String sourceId;
    //源单code
    private String sourceCode;
}
