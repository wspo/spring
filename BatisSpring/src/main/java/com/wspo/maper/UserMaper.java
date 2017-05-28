package com.wspo.maper;

import java.util.List;

import com.wspo.pojo.Order;
import com.wspo.pojo.User;

public interface UserMaper {
	public User getUserById(int userId);

	public List<Order> getUserOrders(int userId);
}
