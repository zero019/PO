package com.zeronly.po.model.base;

import lombok.Data;

import javax.persistence.Column;

/**
 * @author zeronly 2024/3/12
 */
@Data
public class BaseMain extends Base{
    //单据编号
    @Column
    private String code;
    //部门id
    @Column
    private String deptId;
    //申请人id
    @Column
    private String userId;
    //库存组织id
    @Column
    private String poOrganId;
    //采购员id
    @Column
    private String purchaserId;
    //备注
    @Column
    private String notes;
    //财务组织id
    @Column
    private String acuId;
    //收货地址
    @Column
    private String address;
}
