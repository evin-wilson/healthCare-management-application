package com.example.project.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class ApplicationUser {
	@Id
	public String user_name;
	public String user_email;
	public String password;
	public String user_mobile;
	public String location;

	public ApplicationUser(String userName, String user_email, String password, String user_mobile, String location) {
		super();
		this.user_name = userName;
		this.user_email = user_email;
		this.password = password;
		this.user_mobile = user_mobile;
		this.location = location;
	}

	public ApplicationUser() {
		super();
	}

	public ApplicationUser(String userName, String password) {
		super();
		this.user_name = userName;
		this.password = password;
	}

	// public Date user_dob;

}
