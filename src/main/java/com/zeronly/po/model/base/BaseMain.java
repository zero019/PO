package com.zeronly.po.model.base;

import lombok.Data;

/**
 * @author zeronly 2024/3/12
 */
@Data
public class BaseMain extends Base{
    //单据编号
    private String code;
    //部门id
    private String deptId;
    //申请人id
    private String userId;
    //库存组织id
    private String poOrganId;
    //采购员id
    private String purchaserId;
    //备注
    private String notes;
    //财务组织id
    private String acuId;
    //收货地址
    private String address;
}
