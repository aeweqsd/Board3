package com.SpringStarter.example.domain;

import java.io.Serializable;

public class Paging implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int maxnum;
	private int totalpage;
	private int rows;
	private int nowpage;
	private int endPage;
	private int pageScale =5;
	public int getMaxnum() {
		return maxnum;
	}
	public void setMaxnum(int maxnum) {
		this.maxnum = maxnum;
	}
	public int getTotalpage() {
		return totalpage;
	}
	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getNowpage() {
		return nowpage;
	}
	public void setNowpage(int nowpage) {
		this.nowpage = nowpage;
	}
	public int getPageScale() {
		return pageScale;
	}
	public void setPageScale(int pageScale) {
		this.pageScale = pageScale;
	}
	
	
}
