package com.SpringStarter.example.domain;

public class Member {	
	private int idmember;
	private String memberid;
	private String password;
	private String birthday;
	private String name;
	private String gender;
	private boolean islogin;
	public boolean isIslogin() {
		return islogin;
	}
	public void setIslogin(boolean islogin) {
		this.islogin = islogin;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getgender() {
		return gender;
	}
	public void setgender(String gender) {
		this.gender = gender;
	}
	public int getIdmember() {
		return idmember;
	}
	public void setIdmember(int idmember) {
		this.idmember = idmember;
	}
	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
