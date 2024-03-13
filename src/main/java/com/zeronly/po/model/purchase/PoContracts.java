package com.zeronly.po.model.purchase;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zeronly.po.model.base.BaseSub;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 采购合同子表
 * @author zeronly 2024/3/9
 */
@Data
@TableName("po_contracts")
public class PoContracts extends BaseSub {
    @TableId(type = IdType.ASSIGN_ID)
    private String id;

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

    //采购合同pdf文件(记载的是路径地址)
    private String contractDoc;
}
