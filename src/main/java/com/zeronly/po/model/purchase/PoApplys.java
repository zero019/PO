package com.zeronly.po.model.purchase;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.zeronly.po.model.base.BaseSub;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 采购申请子表
 * @author zeronly 2024/3/9
 */
@Data
public class PoApplys extends BaseSub {
    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    //建议订货日期
    private Date dueDate;
    //计划到货日期
    private Date arrDate;
    //需求日期
    private Date reqDate;
}
