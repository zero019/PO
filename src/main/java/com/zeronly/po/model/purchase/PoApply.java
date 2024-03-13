package com.zeronly.po.model.purchase;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zeronly.po.model.base.BaseMain;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 采购申请主表
 * @author zeronly 2024/3/9
 */
@Data
@TableName("po_apply")
public class PoApply extends BaseMain {
    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    //申请日期
    private Date applyDate;
    //采购类型
    private String poType;
    //采购总金额
    private BigDecimal totalMoney;
    //采购原因
    private String reason;

}
