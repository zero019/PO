package com.zeronly.po.controller;


import com.zeronly.po.model.ResResult;
import com.zeronly.po.model.purchase.PoApply;
import com.zeronly.po.model.purchase.PoContract;
import com.zeronly.po.service.IPoContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zeronly
 * @since 2024-03-13
 */
@RestController
@RequestMapping("/po/po-contract")
public class PoContractController {
    @Autowired
    private IPoContractService iPoContractService;
    //增
    @PostMapping("/insert")
    public ResResult insert(@RequestBody List<PoContract> poContractList){
        boolean res = iPoContractService.saveBatch(poContractList);
        if (res){
            return ResResult.ok();
        } else {
            return ResResult.fail();
        }
    }

    //删
    @PostMapping("/del")
    public ResResult del(@RequestBody List<String> poContractIds){
        boolean res = iPoContractService.removeByIds(poContractIds);
        if (res){
            return ResResult.ok();
        } else {
            return ResResult.fail();
        }
    }

    //改
    @PostMapping("/update")
    public ResResult update(@RequestBody List<PoContract> poContractList){
        boolean res = iPoContractService.saveOrUpdateBatch(poContractList);
        if (res){
            return ResResult.ok();
        } else {
            return ResResult.fail();
        }
    }

    //查只能查
    @PostMapping("/read")
    public ResResult read(@RequestBody(required = false) Map<String, Object> query){
        if (CollectionUtils.isEmpty(query)){
            query = new HashMap<>();
        }
        List<PoContract> res = iPoContractService.listByMap(query);
        return ResResult.ok(res);

    }
}
