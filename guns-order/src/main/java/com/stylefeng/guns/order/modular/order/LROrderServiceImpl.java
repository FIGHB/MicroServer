package com.stylefeng.guns.order.modular.order;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.api.order.LROrderService;
import org.springframework.stereotype.Component;

@Component
@Service(interfaceClass = LROrderService.class)
public class LROrderServiceImpl implements LROrderService {
}
