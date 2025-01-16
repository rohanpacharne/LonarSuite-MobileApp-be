package com.lonar.dto;

public class LoginDto {
	
	String userName;
	String password;
	String token;
	Long empId;
	
	
	
	public Long getEmpId() {
		return empId;
	}
	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	@Override
	public String toString() {
		return "LoginDto [userName=" + userName + ", password=" + password + ", token=" + token + ", empId=" + empId
				+ "]";
	}
	

}
