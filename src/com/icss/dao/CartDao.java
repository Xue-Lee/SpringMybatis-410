package com.icss.dao;

import java.util.List;

import com.icss.entity.Cart;


public interface CartDao {
	public List<Cart> findCartByClient(Integer clientId);
	public List<Cart> findCartBookByClient(Integer clientId);
	public Cart findCartBookById(Integer cartId);
}
