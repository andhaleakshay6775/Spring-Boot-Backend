package com.FApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name= "first_name")
    private String firstname;
	@Column(name= "last_name")
    private String lastname;
	@Column(name= "email_id")
    private String emailid;
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", emailid=" + emailid
				+ ", getId()=" + getId() + ", getFirstname()=" + getFirstname() + ", getLastname()=" + getLastname()
				+ ", getEmailid()=" + getEmailid() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
    

}
