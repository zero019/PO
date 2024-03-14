package com.zeronly.po.controller;


import com.zeronly.po.model.ResResult;
import com.zeronly.po.model.common.Dept;
import com.zeronly.po.model.purchase.PoApply;
import com.zeronly.po.service.IDeptService;
import com.zeronly.po.service.IPoApplyService;
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
@RequestMapping("/po/po-apply")
public class PoApplyController {

    @Autowired
    private IPoApplyService iPoApplyService;
    //增
    @PostMapping("/insert")
    public ResResult insert(@RequestBody List<PoApply> applyList){
        boolean res = iPoApplyService.saveBatch(applyList);
        if (res){
            return ResResult.ok();
        } else {
            return ResResult.fail();
        }
    }

    //删
    @PostMapping("/del")
    public ResResult del(@RequestBody List<String> applyIds){
        boolean res = iPoApplyService.removeByIds(applyIds);
        if (res){
            return ResResult.ok();
        } else {
            return ResResult.fail();
        }
    }

    //改
    @PostMapping("/update")
    public ResResult update(@RequestBody List<PoApply> poApplies){
        boolean res = iPoApplyService.saveOrUpdateBatch(poApplies);
        if (res){
            return ResResult.ok();
        } else {
            return ResResult.fail();
        }
    }

    //查只能查
    @GetMapping("/read")
    public ResResult read(@RequestBody Map<String, Object> query){
        List<PoApply> res = iPoApplyService.listByMap(query);
        if (!CollectionUtils.isEmpty(res)){
            return ResResult.ok(res);
        } else {
            return ResResult.fail();
        }
    }

}
