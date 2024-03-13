package com.zeronly.po.model.purchase;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.zeronly.po.model.base.BaseMain;
import lombok.Data;

/**
 * 采购入库主表
 * @author zeronly 2024/3/9
 */
@Data
@TableName("po_warehouse")
public class PoWarehouse extends BaseMain {
    @TableId(type = IdType.ASSIGN_ID)
    @Column
    private String id;

    //是否入库完成
    @Column
    private String isOk;
}
