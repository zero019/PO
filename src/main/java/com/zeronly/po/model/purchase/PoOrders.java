package com.zeronly.po.model.purchase;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.zeronly.po.model.base.BaseSub;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 采购订单子表
 * @author zeronly 2024/3/9
 */
@Data
@TableName("po_orders")
public class PoOrders extends BaseSub {
    @TableId(type = IdType.ASSIGN_ID)
    @Column
    private String id;

    //采购合同单号
    @Column
    private String code;
    //源单Id
    @Column
    private String sourceId;
    //源单code
    @Column
    private String sourceCode;
    //供应商Id
    @Column
    private String suppilerId;
    //供应商名字
    @Column
    private String suppilerName;
    //实际数量
    @Column
    private String apoNumber;
    //实际单价
    @Column
    private BigDecimal aprice;
    //实际金额
    @Column
    private BigDecimal amoney;
    //其他费用说明，前端后端需要规定数据传输的格式例如以分号结尾？
    @Column
    private String olderFee;
    //合计总金额
    @Column
    private BigDecimal totalMoney;
}
