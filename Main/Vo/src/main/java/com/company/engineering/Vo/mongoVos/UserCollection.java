/**
 * 
 */
package com.company.engineering.Vo.mongoVos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Ayushi
 *
 */

@Document(collection="userCollection")
public class UserCollection {

	@Id
	private String id;
	private String name;
	private String department;
	private String token;
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}
	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserCollection [" + (id != null ? "id=" + id + ", " : "") + (name != null ? "name=" + name + ", " : "")
				+ (department != null ? "department=" + department + ", " : "")
				+ (token != null ? "token=" + token : "") + "]";
	}
	public UserCollection() {
		super();
	}
	/**
	 * @param id
	 * @param name
	 * @param department
	 * @param token
	 */
	public UserCollection(String id, String name, String department, String token) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.token = token;
	}



}
