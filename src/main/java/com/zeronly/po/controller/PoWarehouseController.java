package com.zeronly.po.controller;


import com.zeronly.po.model.ResResult;
import com.zeronly.po.model.purchase.PoContract;
import com.zeronly.po.model.purchase.PoWarehouse;
import com.zeronly.po.service.IPoWarehouseService;
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
@RequestMapping("/po/po-warehouse")
public class PoWarehouseController {
    @Autowired
    private IPoWarehouseService iPoWarehouseService;
    //增
    @PostMapping("/insert")
    public ResResult insert(@RequestBody List<PoWarehouse> poWarehouseList){
        boolean res = iPoWarehouseService.saveBatch(poWarehouseList);
        if (res){
            return ResResult.ok();
        } else {
            return ResResult.fail();
        }
    }

    //删
    @PostMapping("/del")
    public ResResult del(@RequestBody List<String> poWarehouseIds){
        boolean res = iPoWarehouseService.removeByIds(poWarehouseIds);
        if (res){
            return ResResult.ok();
        } else {
            return ResResult.fail();
        }
    }

    //改
    @PostMapping("/update")
    public ResResult update(@RequestBody List<PoWarehouse> poWarehouseList){
        boolean res = iPoWarehouseService.saveOrUpdateBatch(poWarehouseList);
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
        List<PoWarehouse> res = iPoWarehouseService.listByMap(query);
        return ResResult.ok(res);
    }
}
