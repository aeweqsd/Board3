package com.SpringStarter.example.domain;


public class Board {
	private int rnum;
	private int idboard;
	private String name;
	private String content;
	private int hit;
	private String time;
	private int idmember;
	public int getrnum() {
		return rnum;
	}
	public void setrnum(int rnum) {
		this.rnum = rnum;
	}
	public int getIdboard() {
		return idboard;
	}
	public void setIdboard(int idboard) {
		this.idboard = idboard;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getIdmember() {
		return idmember;
	}
	public void setIdmember(int idmember) {
		this.idmember = idmember;
	}
}
