package com.zeronly.po.model.base;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

/**
 * 基础类
 * @author zeronly 2024/3/6
 */
@Data
public class Base {

    @Column
    private String creator;
    @Column
    private Date creatTime;
    @Column
    private String modifier;
    @Column
    private Date modiStamp;

    /**
     * 0 没有删除； 1已经删除
     */
    @Column
    private Integer isDeleted;
    /**
     * 状态:有效 1/无效 0
     */
    @Column
    private Integer states;
}
