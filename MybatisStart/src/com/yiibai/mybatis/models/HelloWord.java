package com.yiibai.mybatis.models;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.yiibai.mybatis.dao.IUser;

public class HelloWord {
	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;

	static {
		try {
			reader = Resources.getResourceAsReader("config/Configure.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static SqlSessionFactory getSession() {
		return sqlSessionFactory;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		try {
			IUser iUser = session.getMapper(IUser.class);
			User user = iUser.getUserByID(1);
//			User user = (User) session.selectOne("com.yiibai.mybatis.models.UserMapper.GetUserByID", 2);
			if (user != null) {
				String userInfo = "名字：" + user.getName() + ", 所属部门：" + user.getDept() + ", 主页：" + user.getWebsite();
				System.out.println(userInfo);
			}
		} finally {
			session.close();
		}
	}
}
