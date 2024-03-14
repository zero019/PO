package com.zeronly.po.controller;


import com.zeronly.po.model.ResResult;
import com.zeronly.po.model.purchase.PoContract;
import com.zeronly.po.model.purchase.PoInquery;
import com.zeronly.po.service.IPoInqueryService;
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
@RequestMapping("/po/po-inquery")
public class PoInqueryController {
    @Autowired
    private IPoInqueryService iPoInqueryService;
    //增
    @PostMapping("/insert")
    public ResResult insert(@RequestBody List<PoInquery> poInquerys){
        boolean res = iPoInqueryService.saveBatch(poInquerys);
        if (res){
            return ResResult.ok();
        } else {
            return ResResult.fail();
        }
    }

    //删
    @PostMapping("/del")
    public ResResult del(@RequestBody List<String> poInquerysIds){
        boolean res = iPoInqueryService.removeByIds(poInquerysIds);
        if (res){
            return ResResult.ok();
        } else {
            return ResResult.fail();
        }
    }

    //改
    @PostMapping("/update")
    public ResResult update(@RequestBody List<PoInquery> poInquerys){
        boolean res = iPoInqueryService.saveOrUpdateBatch(poInquerys);
        if (res){
            return ResResult.ok();
        } else {
            return ResResult.fail();
        }
    }

    //查只能查
    @GetMapping("/read")
    public ResResult read(@RequestBody Map<String, Object> query){
        List<PoInquery> res = iPoInqueryService.listByMap(query);
        if (!CollectionUtils.isEmpty(res)){
            return ResResult.ok(res);
        } else {
            return ResResult.fail();
        }
    }

}
