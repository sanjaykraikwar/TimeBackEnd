package com.epam.time.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity

@Table(name = "user")
public class User {
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;

	  @NotNull
	private String userName;

	  @NotNull
	private String password;
	
	private Boolean enabled;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		enabled = enabled;
	}

	public User(Long userId, String userName, String password, boolean enabled) {
		super();
		userId = userId;
		userName = userName;
		password = password;
		enabled = enabled;
	}

	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User [UserId=" + userId + ", UserName=" + userName + ", Password=" + password + ", Enabled=" + enabled
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (enabled ? 1231 : 1237);
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (enabled != other.enabled)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userName != other.userName)
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
	

}
