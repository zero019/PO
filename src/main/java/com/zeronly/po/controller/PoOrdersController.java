package com.zeronly.po.controller;


import com.zeronly.po.model.ResResult;
import com.zeronly.po.model.purchase.PoContract;
import com.zeronly.po.model.purchase.PoOrders;
import com.zeronly.po.service.IPoOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

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
@RequestMapping("/po/po-orders")
public class PoOrdersController {
    @Autowired
    private IPoOrdersService iPoOrdersService;
    //增
    @PostMapping("/insert")
    public ResResult insert(@RequestBody List<PoOrders> poOrders){
        boolean res = iPoOrdersService.saveBatch(poOrders);
        if (res){
            return ResResult.ok();
        } else {
            return ResResult.fail();
        }
    }

    //删
    @PostMapping("/del")
    public ResResult del(@RequestBody List<String> poOrdersIds){
        boolean res = iPoOrdersService.removeByIds(poOrdersIds);
        if (res){
            return ResResult.ok();
        } else {
            return ResResult.fail();
        }
    }

    //改
    @PostMapping("/update")
    public ResResult update(@RequestBody List<PoOrders> poOrders){
        boolean res = iPoOrdersService.saveOrUpdateBatch(poOrders);
        if (res){
            return ResResult.ok();
        } else {
            return ResResult.fail();
        }
    }

    //查只能查
    @GetMapping("/read")
    public ResResult read(@RequestBody Map<String, Object> query){
        List<PoOrders> res = iPoOrdersService.listByMap(query);
        if (!CollectionUtils.isEmpty(res)){
            return ResResult.ok(res);
        } else {
            return ResResult.fail();
        }
    }
}
