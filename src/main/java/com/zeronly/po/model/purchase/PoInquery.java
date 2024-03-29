package com.zeronly.po.model.purchase;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.zeronly.po.model.base.BaseMain;
import lombok.Data;

/**
 * 询比价主表
 * @author zeronly 2024/3/9
 */
@Data
@TableName("po_inquery")
public class PoInquery extends BaseMain {
    @TableId(type = IdType.ASSIGN_ID)
    @Column
    private String id;

    //询价截止日期
    @Column
    private String inqueryDateEnd;
    //源单Id
    @Column
    private String sourceId;
    //源单code
    @Column
    private String sourceCode;
    //询比价选定后总金额
    @Column
    private String totalMoney;
}
