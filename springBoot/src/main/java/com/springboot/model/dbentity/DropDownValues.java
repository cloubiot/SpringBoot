package com.springboot.model.dbentity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class DropDownValues {

	@Id
	@GeneratedValue
	int id;
	int dropDownCategoryId;
	String key;
	String value;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDropDownCategoryId() {
		return dropDownCategoryId;
	}
	public void setDropDownCategoryId(int dropDownCategoryId) {
		this.dropDownCategoryId = dropDownCategoryId;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	
	
}
