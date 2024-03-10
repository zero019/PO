package com.zeronly.po.model.base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 采购合同
 * @author zeronly 2024/3/9
 */
@Data
@TableName("po_contract")
public class PoContract extends Base{
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
    //源单Id
    private String sourceId;
    //源单code
    private String sourceCode;
    //合同金额
    private String contractMoney;
    //采购合同pdf文件(记载的是路径地址)
    private String contractDoc;
}
