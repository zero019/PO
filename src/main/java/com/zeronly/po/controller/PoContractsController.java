package com.zeronly.po.controller;


import com.zeronly.po.model.ResResult;
import com.zeronly.po.model.purchase.PoContract;
import com.zeronly.po.model.purchase.PoContracts;
import com.zeronly.po.service.IPoContractsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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
@Controller
@RequestMapping("/po/po-contract/contracts")
public class PoContractsController {
    @Autowired
    private IPoContractsService iPoContractsService;
    //增
    @PostMapping("/insert")
    public ResResult insert(@RequestBody List<PoContracts> poContractsList){
        boolean res = iPoContractsService.saveBatch(poContractsList);
        if (res){
            return ResResult.ok();
        } else {
            return ResResult.fail();
        }
    }

    //删
    @PostMapping("/del")
    public ResResult del(@RequestBody List<String> poContractsIds){
        boolean res = iPoContractsService.removeByIds(poContractsIds);
        if (res){
            return ResResult.ok();
        } else {
            return ResResult.fail();
        }
    }

    //改
    @PostMapping("/update")
    public ResResult update(@RequestBody List<PoContracts> poContractsList){
        boolean res = iPoContractsService.saveOrUpdateBatch(poContractsList);
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
        List<PoContracts> res = iPoContractsService.listByMap(query);
        return ResResult.ok(res);

    }
}
