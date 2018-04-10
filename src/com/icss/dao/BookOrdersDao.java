package com.icss.dao;

import java.util.List;

import com.icss.entity.BookOrders;

public interface BookOrdersDao {
	public int addOrders(BookOrders orders);
	public List<BookOrders> findOrderByClient(Integer clientId);
}
