package com.wspo.BatisSpring;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wspo.maper.UserMaper;
import com.wspo.pojo.Order;
import com.wspo.pojo.User;

/**
 * Description
 * 
 * @author yiibai
 * @date 2015-4-12
 * @copyright http://www.yiibai.com
 * @email yiibai.com@gmai.com
 * @version 1.0
 */

public class App {

	private static ApplicationContext ctx;

	static {
		ctx = new ClassPathXmlApplicationContext("config/applicationContext.xml");
	}

	public static void main(String[] args) {
		SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) ctx.getBean("sqlSessionFactory");
		SqlSession session = sqlSessionFactory.openSession();
		UserMaper userMaper = session.getMapper(UserMaper.class);
//		UserMaper userMaper = (UserMaper) ctx.getBean("userMaper");
		// 测试id=1的用户查询，可根据数据库中的情况修改.
		User user = userMaper.getUserById(2);
		System.out.println("获取用户 ID=1 的用户名：" + user.getUsername());

		// 得到文章列表测试
		System.out.println("得到用户id为1的所有订单列表:");
		System.out.println("=============================================");
		List<Order> orders = userMaper.getUserOrders(1);

		for (Order order : orders) {
			System.out.println("订单号：" + order.getOrderNo() + "，订单金额：" + order.getMoney());
		}

	}

}