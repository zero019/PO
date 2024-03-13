package com.zeronly.po.model.base;

import lombok.Data;

import javax.persistence.Column;
import java.math.BigDecimal;

/**
 * @author zeronly 2024/3/12
 */
@Data
public class BaseSub extends Base{
    //采购申请主表id
    @Column
    private String pid;
    //行号
    @Column
    private String rowNumber;
    //物料Id
    @Column
    private String materialId;
    //物料编码
    @Column
    private String materialCode;
    //物料名称
    @Column
    private String materialName;
    //规则型号
    @Column
    private String speModel;
    //采购数量
    @Column
    private String poNumber;
    //参考单价
    @Column
    private BigDecimal price;
    //参考金额
    @Column
    private BigDecimal money;
}
