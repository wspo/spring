package com.yiibai.pojo2;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Main {
	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;

	static {
		try {
			reader = Resources.getResourceAsReader("config/Configure3.xml");
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
//		 testAddGroup();
//		 testAddUser();
//		 testAddUserGroup(2,2);
//		 testAddUserGroup(2,3);
		testGetGroupAndUsers(2);

	}

	public static void testGetGroupAndUsers(int groupid) {
		UserGroup userGroup = new UserGroup();
		SqlSession session = sqlSessionFactory.openSession();
		try {
			Group group = session.selectOne("com.yiibai.pojo2.GroupMaper.getGroup", groupid); 
			System.out.println("Group => " + group.getGroupName());
			List<User> users = group.getUsers();
			for (User user : users) {
				System.out.println("\t:" + user.getId() + "\t" + user.getUsername());
			}
		} finally {
			session.close();
		}
	}

	public static void testAddUserGroup(int groupId, int userId) {
		UserGroup userGroup = new UserGroup();
		userGroup.setGroupId(groupId);
		userGroup.setUserId(userId);
		SqlSession session = sqlSessionFactory.openSession();
		try {			
			session.insert("com.yiibai.pojo2.UserGroupMaper.insertUserGroup", userGroup);
			session.commit();
		} finally {
			session.close();
		}

	}

	public static void testAddUser() {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		try {
			User user = new User();
			user.setUsername("User2");
			user.setMobile("13838009988");
			session.insert("com.yiibai.pojo2.UserMaper.insertUser", user);
			session.commit();
			// System.out.println(user.getGroupId());
		} finally {
			session.close();
		}
	}

	public static void testAddGroup() {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		try {
			Group group = new Group();
			group.setGroupName("ÓÃ»§×é-1");
			session.insert("com.yiibai.pojo2.GroupMaper.insertGroup", group);
			session.commit();
			System.out.println(group.getGroupId());
		} finally {
			session.close();
		}
	}
}