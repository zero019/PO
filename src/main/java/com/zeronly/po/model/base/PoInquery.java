package com.zeronly.po.model.base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 询比价主表
 * @author zeronly 2024/3/9
 */
@Data
@TableName("po_inquery")
public class PoInquery extends Base{
    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    //源单Id
    private String sourceId;
    //源单code
    private String sourceCode;
}
