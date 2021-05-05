package com.te.springrest.beans;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserBean implements Serializable {

	private String user;

	private String pwd;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
}
