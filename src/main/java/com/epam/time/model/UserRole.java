package com.epam.time.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity

@Table(name = "userrole")
public class UserRole {
	
	 @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	private Long userRoleId;
	  @NotNull
	private Long userId;
	  @NotNull
	private Long role;
	public Long getUserRoleId() {
		return userRoleId;
	}
	public void setUserRoleId(int userRoleId) {
		userRoleId = userRoleId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		userId = userId;
	}
	public Long getRole() {
		return role;
	}
	public void setRole(int role) {
		role = role;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + role);
		result = (int) (prime * result + userId);
		result = (int) (prime * result + userRoleId);
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserRole other = (UserRole) obj;
		if (role != other.role)
			return false;
		if (userId != other.userId)
			return false;
		if (userRoleId != other.userRoleId)
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserRole [UserRoleId=" + userRoleId + ", UserId=" + userId + ", Role=" + role + "]";
	}
	public UserRole(int userRoleId, int userId, int role) {
		super();
		userRoleId = userRoleId;
		userId = userId;
		role = role;
	}
	public UserRole() {
		super();
	}
	
	

}
