package com.CarStore.service;

import com.CarStore.model.Cart;

public interface CartService {

    Cart getCartById(int cartId);

    void update(Cart cart);
}

