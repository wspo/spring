package com.yiibai.pojo2;

import java.util.List;

/**
 * @describe: Group
 * @author: Yiibai
 * @version: V1.0
 * @copyright http://www.yiibai.com
 */
public class Group {
	private int groupId;
	private String groupName;
	private List<User> users;

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

}
