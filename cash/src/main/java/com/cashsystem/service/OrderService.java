package com.cashsystem.service;

import com.cashsystem.dao.OrderDao;
import com.cashsystem.entity.Order;

import java.util.List;

public class OrderService {
    public OrderDao orderDao;
    public OrderService() {
        orderDao = new OrderDao();
    }
    public boolean commitOrder(Order order) {
        return this.orderDao.commitOrder(order);
    }

    public List<Order> queryOrderByAccount(Integer id) {
        return this.orderDao.queryOrderByAccount(id);
    }
}
