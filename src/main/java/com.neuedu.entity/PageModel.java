package com.neuedu.entity;

import com.sun.xml.internal.bind.v2.runtime.RuntimeUtil;

import java.io.Serializable;
import java.util.List;

public class PageModel<T> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//ÿһҳ���ݼ���
	private List<T> data;
	//�ܹ��ж���ҳ
	private int totalPage;
	
	
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}


	@Override
	public String toString() {
		return "PageModel{" +
				"data=" + data +
				", totalPage=" + totalPage +
				'}';
	}
}
