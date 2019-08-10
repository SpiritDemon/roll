package com.spiritdemon.pojo;

import java.util.Date;

public class Roll {
	private int id;
	//用户名称
	private String username;
	//roll到的点数
	private String rollValue;
	//roll点时间
	private Date time;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRollValue() {
		return rollValue;
	}
	public void setRollValue(String rollValue) {
		this.rollValue = rollValue;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "Roll [id=" + id + ", username=" + username + ", rollValue=" + rollValue + ", time=" + time + "]";
	}
}
