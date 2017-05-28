package com.yiibai.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yiibai.maper.UserMaper;
import com.yiibai.pojo.Order;
import com.yiibai.util.Page;

/**
 * @describe: 读取一个用户下的所有订单
 * @author: Yiibai
 * @version: V1.0
 * @copyright http://www.yiibai.com
 */

// http://localhost:8080/mybatis07-spring-mvc/user/orders
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserMaper userMaper;

	@RequestMapping("/orders")
	public ModelAndView listall(HttpServletRequest request, HttpServletResponse response) {
		List<Order> orders = userMaper.getUserOrders(1);
		System.out.println("orders");
		ModelAndView mav = new ModelAndView("user_orders");
		mav.addObject("orders", orders);
		return mav;
	}

	/**
	 * 订单分页
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/orderpages")
	public ModelAndView pageList(HttpServletRequest request, HttpServletResponse response) {
		int currentPage = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
		int pageSize = 3;
		if (currentPage <= 0) {
			currentPage = 1;
		}
		int currentResult = (currentPage - 1) * pageSize;

		System.out.println(request.getRequestURI());
		System.out.println(request.getQueryString());

		Page page = new Page();
		page.setShowCount(pageSize);
		page.setCurrentResult(currentResult);
		List<Order> orders = userMaper.getOrderListPage(page, 1);

		System.out.println("Current page =>" + page);

		int totalCount = page.getTotalResult();

		int lastPage = 0;
		if (totalCount % pageSize == 0) {
			lastPage = totalCount % pageSize;
		} else {
			lastPage = 1 + totalCount / pageSize;
		}

		if (currentPage >= lastPage) {
			currentPage = lastPage;
		}

		String pageStr = "";

		if (currentPage == 1) {
			pageStr = String.format("上一页    <a href=\"%s\">下一页</a>",
					request.getRequestURI() + "?page=" + (currentPage + 1));
		} else if (currentPage == lastPage) {
			pageStr = String.format("<a href=\"%s\">上一页</a>    下一页",
					request.getRequestURI() + "?page=" + (currentPage - 1));
		} else {
			pageStr = String.format("<a href=\"%s\">上一页</a>    <a href=\"%s\">下一页</a>",
					request.getRequestURI() + "?page=" + (currentPage - 1),
					request.getRequestURI() + "?page=" + (currentPage + 1));
		}

		// 制定视图，也就是list.jsp
		ModelAndView mav = new ModelAndView("pagelist");
		mav.addObject("orders", orders);
		mav.addObject("pagelist", pageStr);
		return mav;
	}
}