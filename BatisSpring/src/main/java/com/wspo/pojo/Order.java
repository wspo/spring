package com.wspo.pojo;

/**
 * @describe: Order -
 * @author: Yiibai
 * @version: V1.0
 * @copyright http://www.yiibai.com
 */
public class Order {
	private int orderId;
	private String orderNo;
	private float money;
	private int userId;
	private User user;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public float getMoney() {
		return money;
	}

	public void setMoney(float money) {
		this.money = money;
	}

}