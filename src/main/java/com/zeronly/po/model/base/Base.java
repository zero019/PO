package com.zeronly.po.model.base;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 基础类
 * @author zeronly 2024/3/6
 */
@Data
public class Base {

    private String creator;

    private Date creatTime;

    private String modifier;

    private Date modiStamp;

    /**
     * 0 没有删除； 1已经删除
     */
    private Integer isDeleted;
}
