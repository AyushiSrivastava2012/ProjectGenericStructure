package com.company.engineering.Vo.mongo;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="UserLogin")
public class UserLogin {

	private User user;
	private String token;
	private int noOfLogins;
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserLogin [" + (user != null ? "user=" + user + ", " : "")
				+ (token != null ? "token=" + token + ", " : "") + "noOfLogins=" + noOfLogins + "]";
	}

	/**
	 * @param user
	 * @param token
	 * @param noOfLogins
	 */
	public UserLogin(User user, String token, int noOfLogins) {
		super();
		this.user = user;
		this.token = token;
		this.noOfLogins = noOfLogins;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * @return the noOfLogins
	 */
	public int getNoOfLogins() {
		return noOfLogins;
	}

	/**
	 * @param noOfLogins the noOfLogins to set
	 */
	public void setNoOfLogins(int noOfLogins) {
		this.noOfLogins = noOfLogins;
	}
	
	
	
	
}
