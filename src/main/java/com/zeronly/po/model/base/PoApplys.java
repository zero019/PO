package com.zeronly.po.model.base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 采购申请子表
 * @author zeronly 2024/3/9
 */
@Data
public class PoApplys extends Base{
    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    //采购申请主表id
    private String pid;
    //行号
    private String rowNumber;
    //物料Id
    private String materialId;
    //物料编码
    private String materialCode;
    //物料名称
    private String materialName;
    //规则型号
    private String speModel;
    //采购数量
    private String poNumber;
    //参考单价
    private BigDecimal price;
    //参考金额
    private BigDecimal money;
    //建议订货日期
    private Date dueDate;
    //计划到货日期
    private Date arrDate;
    //需求日期
    private Date reqDate;
}
