package com.zeronly.po.controller;


import com.zeronly.po.model.ResResult;
import com.zeronly.po.model.purchase.PoContract;
import com.zeronly.po.model.purchase.PoInquerys;
import com.zeronly.po.service.IPoInquerysService;
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
@RequestMapping("/po/po-inquery/inquerys")
public class PoInquerysController {
    @Autowired
    private IPoInquerysService iPoInquerysService;
    //增
    @PostMapping("/insert")
    public ResResult insert(@RequestBody List<PoInquerys> poInquerysList){
        boolean res = iPoInquerysService.saveBatch(poInquerysList);
        if (res){
            return ResResult.ok();
        } else {
            return ResResult.fail();
        }
    }

    //删
    @PostMapping("/del")
    public ResResult del(@RequestBody List<String> poInquerysIds){
        boolean res = iPoInquerysService.removeByIds(poInquerysIds);
        if (res){
            return ResResult.ok();
        } else {
            return ResResult.fail();
        }
    }

    //改
    @PostMapping("/update")
    public ResResult update(@RequestBody List<PoInquerys> poInquerysList){
        boolean res = iPoInquerysService.saveOrUpdateBatch(poInquerysList);
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
        List<PoInquerys> res = iPoInquerysService.listByMap(query);
        return ResResult.ok(res);
    }
}
