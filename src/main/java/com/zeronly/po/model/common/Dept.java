package com.zeronly.po.model.common;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zeronly.po.model.base.Base;
import lombok.Data;

import javax.persistence.Column;

/**
 * @author zeronly 2024/3/12
 */
@Data
@TableName("dept")
public class Dept extends Base {
    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    //部门名称
    @Column
    private String deptName;
}
