package com.CarStore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CarStore.dao.CustomerOrderDao;
import com.CarStore.model.Cart;
import com.CarStore.model.CartItem;
import com.CarStore.model.CustomerOrder;
import com.CarStore.service.CartService;
import com.CarStore.service.CustomerOrderService;


@Service
public class CustmerOrderServiceImpl implements CustomerOrderService{

    @Autowired
    private CustomerOrderDao customerOrderDao;

    @Autowired
    private CartService cartService;

    public void addCustomerOrder(CustomerOrder customerOrder){
        customerOrderDao.addCustomerOrder(customerOrder);
    }

    public double getCustomerOrderGrandTotal(int cartId){
        double grandTotal = 0;
        Cart cart = cartService.getCartById(cartId);
        List<CartItem> cartItems = cart.getCartItems();

        for (CartItem item : cartItems){
            grandTotal += item.getTotalPrice();
        }

        return grandTotal;
    }

} // The End of Class;
