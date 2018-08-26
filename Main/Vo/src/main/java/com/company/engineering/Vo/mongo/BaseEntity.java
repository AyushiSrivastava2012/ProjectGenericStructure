package com.company.engineering.Vo.mongo;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class BaseEntity {
	
	@Id
	private String id;
	private String name;
	private User createdBy;
	private User deletedBy;
	private User updatedBy;
	private Date createdOn;
	private Date deletedOn;
	private Date updatedOn;
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
	 * @return the createdBy
	 */
	public User getCreatedBy() {
		return createdBy;
	}
	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}
	/**
	 * @return the deletedBy
	 */
	public User getDeletedBy() {
		return deletedBy;
	}
	/**
	 * @param deletedBy the deletedBy to set
	 */
	public void setDeletedBy(User deletedBy) {
		this.deletedBy = deletedBy;
	}
	/**
	 * @return the updatedBy
	 */
	public User getUpdatedBy() {
		return updatedBy;
	}
	/**
	 * @param updatedBy the updatedBy to set
	 */
	public void setUpdatedBy(User updatedBy) {
		this.updatedBy = updatedBy;
	}
	/**
	 * @return the createdOn
	 */
	public Date getCreatedOn() {
		return createdOn;
	}
	/**
	 * @param createdOn the createdOn to set
	 */
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	/**
	 * @return the deletedOn
	 */
	public Date getDeletedOn() {
		return deletedOn;
	}
	/**
	 * @param deletedOn the deletedOn to set
	 */
	public void setDeletedOn(Date deletedOn) {
		this.deletedOn = deletedOn;
	}
	/**
	 * @return the updatedOn
	 */
	public Date getUpdatedOn() {
		return updatedOn;
	}
	/**
	 * @param updatedOn the updatedOn to set
	 */
	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BaseEntity [" + (id != null ? "id=" + id + ", " : "") + (name != null ? "name=" + name + ", " : "")
				+ (createdBy != null ? "createdBy=" + createdBy + ", " : "")
				+ (deletedBy != null ? "deletedBy=" + deletedBy + ", " : "")
				+ (updatedBy != null ? "updatedBy=" + updatedBy + ", " : "")
				+ (createdOn != null ? "createdOn=" + createdOn + ", " : "")
				+ (deletedOn != null ? "deletedOn=" + deletedOn + ", " : "")
				+ (updatedOn != null ? "updatedOn=" + updatedOn : "") + "]";
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
	 */
	public BaseEntity(String id, String name, User createdBy, User deletedBy, User updatedBy, Date createdOn,
			Date deletedOn, Date updatedOn) {
		super();
		this.id = id;
		this.name = name;
		this.createdBy = createdBy;
		this.deletedBy = deletedBy;
		this.updatedBy = updatedBy;
		this.createdOn = createdOn;
		this.deletedOn = deletedOn;
		this.updatedOn = updatedOn;
	}
	
	public BaseEntity(){
		
	}
	
	
}
