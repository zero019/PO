package com.zeronly.po.model.base;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author zeronly 2024/3/12
 */
@Data
public class BaseSub extends Base{
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
}
