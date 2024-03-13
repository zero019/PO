package com.zeronly.po.model.common;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.zeronly.po.model.base.Base;
import lombok.Data;

/**
 * @author zeronly 2024/3/12
 */
@Data
public class Dept extends Base {
    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    //部门名称
    private String deptName;
}
