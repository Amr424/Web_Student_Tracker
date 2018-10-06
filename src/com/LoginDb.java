package com;


import javax.persistence.*;

/**
 * Entity implementation class for Entity: LoginEntity
 *
 */
@Entity
@Table(name = "login")
public class LoginDb {

	@Id
	@Column(name = "Id", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "user_name")
	private String user_name;
	
	@Column(name = "password")
	private String password;
	
	


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
