package com;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Login {

	private String userName;
	private String password;

	public Login() {

	}

	StudentDbUtil sd = new StudentDbUtil();

	public String loginControl() {
		LoginDb login = new LoginDb();
		login = sd.login();

		if (login.getUser_name().equals(userName) && login.getPassword().equals(password)) {
			return "success";
		} else

			return "error";

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
		return "Login [userName=" + userName + ", password=" + password + "]";
	}

}
