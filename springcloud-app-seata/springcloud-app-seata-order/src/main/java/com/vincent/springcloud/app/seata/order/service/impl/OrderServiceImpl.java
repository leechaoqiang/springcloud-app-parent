package com.vincent.springcloud.app.seata.order.service.impl;

import com.alibaba.fastjson.JSON;
import com.vincent.springcloud.app.seata.order.dao.OrderDao;
import com.vincent.springcloud.app.seata.order.entity.Order;
import com.vincent.springcloud.app.seata.order.feign.SeataAccountApi;
import com.vincent.springcloud.app.seata.order.feign.SeataStorageApi;
import com.vincent.springcloud.app.seata.order.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * @author vincent.li
 */
@Slf4j
@Service("orderServiceImpl")
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;
    @Resource
    private SeataStorageApi storageApi;
    @Resource
    private SeataAccountApi accountApi;

    /**
     * 创建订单
     * @param order
     * @return
     * 测试结果：
     * 1.添加本地事务：仅仅扣减库存
     * 2.不添加本地事务：创建订单，扣减库存
     */
    @Override
    @GlobalTransactional(name = "fsp-create-order",rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("create order:{},------->交易开始", JSON.toJSONString(order));
        //本地方法
        orderDao.create(order);

        //远程方法 扣减库存
        log.info("------->扣减库存开始order中");
        storageApi.decrease(order.getProductId(),order.getCount());
        log.info("------->扣减库存结束order中");

        //远程方法 扣减账户余额
        log.info("------->扣减账户开始order中");
        accountApi.decrease(order.getUserId(),order.getMoney());
        log.info("------->扣减账户结束order中");

        log.info("create order------->交易结束");
    }
}
