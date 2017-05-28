package com.yiibai.maper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yiibai.pojo.Order;
import com.yiibai.pojo.User;
import com.yiibai.util.Page;

public interface UserMaper { 
	public User getUserById(int userId);
	public List<Order> getUserOrders(int userId);
	public List<Order> getOrderListPage(@Param("page") Page page, @Param("userid") int userid);
}
