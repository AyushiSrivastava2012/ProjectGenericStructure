/**
 * 
 */
package com.company.engineering.Vo.mongo;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Ayushi
 *
 */

@Document(collection="User")
public class User extends BaseEntity{

	private String department;
	
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
	
	public User() {
		super();
	}
	
	/**
	 * @param id
	 * @param name
	 * @param createdBy
	 * @param deletedBy
	 * @param updatedBy
	 * @param createdOn
	 * @param deletedOn
	 * @param updatedOn
	 * @param department
	 */
	public User(String id, String name, User createdBy, User deletedBy, User updatedBy, Date createdOn, Date deletedOn,
			Date updatedOn, String department) {
		super(id, name, createdBy, deletedBy, updatedBy, createdOn, deletedOn, updatedOn);
		this.department = department;
	}
	


}
