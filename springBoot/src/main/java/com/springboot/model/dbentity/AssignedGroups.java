package com.springboot.model.dbentity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AssignedGroups {

	@Id
	@GeneratedValue
	int id;
	String name;
	String groupOwner;
	String groupEmail;
	String description;
	String active;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGroupOwner() {
		return groupOwner;
	}
	public void setGroupOwner(String groupOwner) {
		this.groupOwner = groupOwner;
	}
	public String getGroupEmail() {
		return groupEmail;
	}
	public void setGroupEmail(String groupEmail) {
		this.groupEmail = groupEmail;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	
	
}
