package com.zeronly.po.controller;


import com.zeronly.po.model.ResResult;
import com.zeronly.po.model.common.Dept;
import com.zeronly.po.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zeronly
 * @since 2024-03-13
 */
@RestController
@RequestMapping("/po/dept")
public class DeptController {
    @Autowired
    private IDeptService iDeptService;
    //增
    @PostMapping("/insert")
    public ResResult insert(@RequestBody List<Dept> depts){
        boolean res = iDeptService.saveBatch(depts);
        if (res){
            return ResResult.ok();
        } else {
            return ResResult.fail();
        }
    }

    //删
    @PostMapping("/del")
    public ResResult del(@RequestBody List<String> deptsId){
        boolean res = iDeptService.removeByIds(deptsId);
        if (res){
            return ResResult.ok();
        } else {
            return ResResult.fail();
        }
    }

    //改
    @PostMapping("/update")
    public ResResult update(@RequestBody List<Dept> depts){
        boolean res = iDeptService.saveOrUpdateBatch(depts);
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
        List<Dept> res = iDeptService.listByMap(query);

        return ResResult.ok(res);
    }

}
