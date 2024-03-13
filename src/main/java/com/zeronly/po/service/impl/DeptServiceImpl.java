package com.zeronly.po.service.impl;

import com.zeronly.po.model.common.Dept;
import com.zeronly.po.mapper.DeptMapper;
import com.zeronly.po.service.IDeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zeronly
 * @since 2024-03-13
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements IDeptService {

}
