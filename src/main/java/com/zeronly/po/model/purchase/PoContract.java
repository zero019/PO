package com.zeronly.po.model.purchase;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zeronly.po.model.base.BaseMain;
import lombok.Data;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import java.util.Date;

/**
 * 采购合同
 * @author zeronly 2024/3/9
 */
@Data
@TableName("po_contract")
public class PoContract extends BaseMain {
    @TableId(type = IdType.ASSIGN_ID)
    @Column
    private String id;

    //供应商Id
    @Column
    private Integer supplierId;
    //合同类型
    @Column
    private String contractType;
    //开始期
    @Column
    private Date validateDateBegin;
    //结束期
    @Column
    private Date validateDateEnd;
    //合同执行状态
    @Column
    private String status;
    //合同金额
    @Column
    private String contractMoney;
    //选定后总金额
    @Column
    private String totalMoney;

    //源单Id
    @Column
    private String sourceId;
    //源单code
    @Column
    private String sourceCode;
}
