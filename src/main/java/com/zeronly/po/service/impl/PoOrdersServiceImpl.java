package com.zeronly.po.service.impl;

import com.zeronly.po.model.purchase.PoOrders;
import com.zeronly.po.mapper.PoOrdersMapper;
import com.zeronly.po.service.IPoOrdersService;
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
public class PoOrdersServiceImpl extends ServiceImpl<PoOrdersMapper, PoOrders> implements IPoOrdersService {

}
