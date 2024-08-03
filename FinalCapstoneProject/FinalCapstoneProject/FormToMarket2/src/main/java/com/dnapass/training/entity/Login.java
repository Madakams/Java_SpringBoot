package com.dnapass.training.entity;


public class Login extends User
{
	private Integer userid;
	private String password;
	private String role;
	public Integer getUserid()
	{
		return userid;
	}
	public void setUserid(int userid)
	{
		this.userid = userid;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getRole()
	{
		return role;
	}
	public void setRole(String role)
	{
		this.role = role;
	}
	public Login(int userid, String password, String role)
	{
		super();
		this.userid = userid;
		this.password = password;
		this.role = role;
	}
	public Login()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString()
	{
		return "{id: " + userid + ", username: " + password + ", role: " + role + "}";
	}
}

