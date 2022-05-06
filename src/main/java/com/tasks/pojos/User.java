package com.tasks.pojos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@NamedQuery(name = "User.findAllOrderedDescendingByMail",query = "SELECT user FROM User user ORDER BY user.mail DESC")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@NotNull
	@Size(min=5, max = 15, message="user name should be between 5 and 15")
	private String userName;
	@NotNull
	@Email(message="Enter valid Email address")
	private String mail;
	@NotNull
	@Size(min=5,max=15, message=" Enter Password in Acceptable Range from 5 to 15")
	private String password;
	
	
	
	
	public User() {}
	
	
	
	public User(@NotNull @Size(min = 5, max = 15, message = "user name should be between 5 and 15") String userName,
			@NotNull @Email(message = "Enter valid Email address") String mail,
			@NotNull @Size(min = 5, max = 15, message = " Enter Password in Acceptable Range from 5 to 15") String password) {
		super();
		this.userName = userName;
		this.mail = mail;
		this.password = password;
	}
	



	


	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getMail() {
		return mail;
	}



	public void setMail(String mail) {
		this.mail = mail;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	@Override
	public String toString() {
		return "User is  [userName=" + userName + ", mail=" + mail + ", password=" + password + "]";
	}
	
	
	
}
