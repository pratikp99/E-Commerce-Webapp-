package com.revature.ecom.serviceImpl;

import java.util.List;

import com.revature.ecom.DAO.orderDAO;
import com.revature.ecom.DAO.orderedProductDAO;
import com.revature.ecom.Models.orderModel;
import com.revature.ecom.Utils.DatabaseUtil;
import com.revature.ecom.service.OrderService;

public class OrderServiceImpl implements OrderService {
    private orderDAO orderDao;
    private orderedProductDAO ordProdDao;

    public OrderServiceImpl() throws ClassNotFoundException {
        this.orderDao = new orderDAO(DatabaseUtil.getConnection());
        this.ordProdDao = new orderedProductDAO(DatabaseUtil.getConnection());
    }

    @Override
    public List<orderModel> getAllOrdersByUserId(int userId) {
        return orderDao.getAllOrderByUserId(userId);
    }
}
