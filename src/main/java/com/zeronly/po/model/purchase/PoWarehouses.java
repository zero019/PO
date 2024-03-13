package com.zeronly.po.model.purchase;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zeronly.po.model.base.BaseSub;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 采购入库子表
 * @author zeronly 2024/3/9
 */
@Data
@TableName("po_warehouses")
public class PoWarehouses extends BaseSub {
    //采购合同单号
    private String code;
    //源单Id
    private String sourceId;
    //源单code
    private String sourceCode;
    //供应商Id
    private String suppilerId;
    //供应商名字
    private String suppilerName;
    //实际数量
    private String apoNumber;
    //实际单价
    private BigDecimal aprice;
    //实际金额
    private BigDecimal amoney;
    //其他费用说明，前端后端需要规定数据传输的格式例如以分号结尾？
    private String olderFee;
    //合计总金额
    private BigDecimal totalMoney;
    //是否结清款项
    private Integer isOk;
}
