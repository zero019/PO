package com.zeronly.po.model.purchase;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zeronly.po.model.base.BaseSub;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 询比价子表：里面有每个供应商对应的物料的价格提交，最终会根据物料Id进行中标分类
 * @author zeronly 2024/3/9
 */
@Data
@TableName("po_inquerys")
public class PoInquerys extends BaseSub {
    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    //供应商提交价格字段部分
    //可提供数量
    private String apoNumber;
    //实际单价
    private BigDecimal aprice;
    //实际金额
    private BigDecimal amoney;
    //供应商Id
    private String suppilerId;
    //供应商名字
    private String suppilerName;
    //其他费用说明，前端后端需要规定数据传输的格式例如以分号结尾？
    private String olderFee;
    //合计总金额
    private BigDecimal totalMoney;
    //在该单据业务下，是否已被中标
    private Integer isOk;

    //源单Id
    private String sourceId;
    //源单code
    private String sourceCode;
}
