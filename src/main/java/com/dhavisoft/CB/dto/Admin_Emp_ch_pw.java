package com.dhavisoft.CB.dto;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "employee_login")
public class Admin_Emp_ch_pw implements Serializable {

	private static final long serialVersionUID = -6457307789706133809L;
	
	private String userName;
	private String bank_id;
	private String password;
	
	private String newpw;
	private String cnewpw;
	private String test;

	@Id
	@Column(name = "employee_userName")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "employee_id")
	public String getBank_id() {
		return bank_id;
	}

	public void setBank_id(String bank_id) {
		this.bank_id = bank_id;
	}

	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Transient
	public String getNewpw() {
		return newpw;
	}

	public void setNewpw(String newpw) {
		this.newpw = newpw;
	}

	@Transient
	public String getCnewpw() {
		return cnewpw;
	}

	public void setCnewpw(String cnewpw) {
		this.cnewpw = cnewpw;
	}

	@Transient
	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

}