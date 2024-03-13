package com.zeronly.po.model.purchase;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zeronly.po.model.base.BaseMain;
import lombok.Data;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
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
    @Column
    private String id;

    //申请日期
    @Column
    private Date applyDate;
    //采购类型
    @Column
    private String poType;
    //采购总金额
    @Column
    private BigDecimal totalMoney;
    //采购原因
    @Column
    private String reason;

}
