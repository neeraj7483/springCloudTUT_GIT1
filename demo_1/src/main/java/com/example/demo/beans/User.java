package com.example.demo.beans;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement
@Entity
@Table(name="temp_user")
public class User {

	@Id
	private int id;
	@Size(min=2,message="Invalid name(name should have minimum of 2 characters)")
	private String name;
	@Past(message="Invlaid DOB(DOB can not be of future)")
	private Date dob;

	public User() {

	}

	public User(String name, Date dob) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
	}

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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", dob=" + dob + "]";
	}
	
}
