package com.revature.ecom.serviceImpl;

import java.util.List;

import com.revature.ecom.DAO.orderedProductDAO;
import com.revature.ecom.Models.orderedProductModel;
import com.revature.ecom.Utils.DatabaseUtil;
import com.revature.ecom.service.OrderedProductService;

public class OrderedProductServiceImpl implements OrderedProductService {

    private orderedProductDAO orderedProductDao;

    public OrderedProductServiceImpl() throws ClassNotFoundException {
        // Initialize the DAO with a database connection
        orderedProductDao = new orderedProductDAO(DatabaseUtil.getConnection());
    }

    @Override
    public List<orderedProductModel> getAllOrderedProducts(int orderId) {
        // Use the DAO to fetch all ordered products for the given orderId
        return orderedProductDao.getAllOrderedProduct(orderId);
    }
}
