package com.vincent.springcloud.app.seata.order.service.impl;

import com.alibaba.fastjson.JSON;
import com.vincent.springcloud.app.seata.order.dao.OrderDao;
import com.vincent.springcloud.app.seata.order.entity.Order;
import com.vincent.springcloud.app.seata.order.feign.SeataAccountClient;
import com.vincent.springcloud.app.seata.order.feign.SeataStorageClient;
import com.vincent.springcloud.app.seata.order.service.OrderService;
import com.vincent.springcloud.seata.common.model.Response;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * @author vincent.li
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;
    @Resource
    private SeataStorageClient storageClient;
    @Resource
    private SeataAccountClient accountClient;

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
        Response<Boolean> storageResponse = storageClient.decrease(order.getProductId(),order.getCount());
        if (!storageResponse.isSuccess() || !storageResponse.getData()) {
            throw new RuntimeException("扣减库存处理失败");
        }
        log.info("------->扣减库存结束order中");

        //远程方法 扣减账户余额
        log.info("------->扣减账户开始order中");
        Response<Boolean> accountResponse =  accountClient.decrease(order.getUserId(),order.getMoney());
        if (!accountResponse.isSuccess() || !accountResponse.getData()) {
            throw new RuntimeException("扣减账户处理失败");
        }
        log.info("------->扣减账户结束order中");

        log.info("create order------->交易结束");
    }
}
