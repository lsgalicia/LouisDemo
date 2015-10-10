package org.lsgalicia.dao.service;

import org.lsgalicia.common.Order;
import org.lsgalicia.dao.OrdersDao;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class OrderService extends EntityService<Order> implements OrdersDao {

}
