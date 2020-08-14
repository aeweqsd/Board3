package com.SpringStarter.example.domain;

public class Comment {
	private int idcomment;
	private String content;
	private int selfkey;
	private String time;
	private int board_idboard;
	private int idmember;
	public int getIdcomment() {
		return idcomment;
	}
	public void setIdcomment(int idcomment) {
		this.idcomment = idcomment;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getSelfkey() {
		return selfkey;
	}
	public void setSelfkey(int selfkey) {
		this.selfkey = selfkey;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getBoard_idboard() {
		return board_idboard;
	}
	public void setBoard_idboard(int board_idboard) {
		this.board_idboard = board_idboard;
	}
	public int getIdmember() {
		return idmember;
	}
	public void setIdmember(int idmember) {
		this.idmember = idmember;
	}
	
}
