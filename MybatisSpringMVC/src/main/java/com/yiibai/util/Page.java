package com.yiibai.util;

import java.io.Serializable;

public class Page implements Serializable {

	private static final long serialVersionUID = 5599632798780L;

	// pagesize ��ÿһҳ��ʾ��¼��
	private int showCount = 3;
	// ��ҳ��
	private int totalPage;
	// �ܼ�¼��
	private int totalResult;
	// ��ǰҳ
	private int currentPage;
	// ��ǰ��ʾ���� ID, �� mysql limit �о��ǵ�һ������.
	private int currentResult;
	// �����ֶ�
	private String sortField;
	// ����ʽ
	private String order;

	public int getShowCount() {
		return showCount;
	}

	public void setShowCount(int showCount) {
		this.showCount = showCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalResult() {
		return totalResult;
	}

	public void setTotalResult(int totalResult) {
		this.totalResult = totalResult;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getCurrentResult() {
		return currentResult;
	}

	public void setCurrentResult(int currentResult) {
		this.currentResult = currentResult;
	}

	public String getSortField() {
		return sortField;
	}

	public void setSortField(String sortField) {
		this.sortField = sortField;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

}
