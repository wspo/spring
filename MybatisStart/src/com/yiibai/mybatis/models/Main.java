package com.yiibai.mybatis.models;

import java.io.Reader;
import java.text.MessageFormat;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.yiibai.mybatis.dao.IUser;
import com.yiibai.mybatis.models.User;

public class Main {
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
		// �û������б�
		 getUserList();
		// ��������
//		 testInsert();
//		 testUpdate();

		// ɾ������
//		testDelete();
	}

	//
	public static void testInsert() {
		try {
			// ��ȡSession����
			SqlSession session = sqlSessionFactory.openSession();
			// ��ȡMapper
			IUser userMapper = session.getMapper(IUser.class);
			System.out.println("Test insert start...");
			// ִ�в���
			User user = new User();
			user.setId(0);
			user.setName("Google");
			user.setDept("Tech");
			user.setWebsite("http://www.google.com");
			user.setPhone("120");
			userMapper.insertUser(user);
			// �ύ����
			session.commit();

			// ��ʾ����֮��User��Ϣ
			System.out.println("After insert");
			getUserList();
			System.out.println("Test insert finished...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ��ȡ�û��б�
	public static void getUserList() {
		try {
			SqlSession session = sqlSessionFactory.openSession();
			IUser iuser = session.getMapper(IUser.class);
			// ��ʾUser��Ϣ
			System.out.println("Test Get start...");
			printUsers(iuser.getUserList());
			System.out.println("Test Get finished...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testUpdate() {
		try {
			SqlSession session = sqlSessionFactory.openSession();
			IUser iuser = session.getMapper(IUser.class);
			System.out.println("Test update start...");
			printUsers(iuser.getUserList());
			// ִ�и���
			User user = iuser.getUser(3);
			user.setName("New name");
			iuser.updateUser(user);
			// �ύ����
			session.commit();
			// ��ʾ����֮��User��Ϣ
			System.out.println("After update");
			printUsers(iuser.getUserList());
			System.out.println("Test update finished...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ɾ���û���Ϣ
	public static void testDelete() {
		try {
			SqlSession session = sqlSessionFactory.openSession();
			IUser iuser = session.getMapper(IUser.class);
			System.out.println("Test delete start...");
			// ��ʾɾ��֮ǰUser��Ϣ
			System.out.println("Before delete");
			printUsers(iuser.getUserList());
			// ִ��ɾ��
			iuser.deleteUser(3);
			// �ύ����
			session.commit();
			// ��ʾɾ��֮��User��Ϣ
			System.out.println("After delete");
			printUsers(iuser.getUserList());
			System.out.println("Test delete finished...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * ��ӡ�û���Ϣ������̨
	 * 
	 * @param users
	 */
	private static void printUsers(final List<User> users) {
		int count = 0;

		for (User user : users) {
			System.out.println(MessageFormat.format("============= User[{0}]=================", ++count));
			System.out.println("User Id: " + user.getId());
			System.out.println("User Name: " + user.getName());
			System.out.println("User Dept: " + user.getDept());
			System.out.println("User Website: " + user.getWebsite());
		}
	}
}