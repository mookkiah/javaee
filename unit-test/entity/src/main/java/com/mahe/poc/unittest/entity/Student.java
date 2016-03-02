package com.mahe.poc.unittest.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "STUDENTS")
public class Student  implements Serializable{

	private static final long serialVersionUID = -3522913221207072336L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;                      
	
	@Column(name = "LAST_NAME", length = 35)
	private String lastName;
	
	@Column(name = "FIRST_NAME", nullable = false, length = 35)
	private String firstName;
	
	@Column(name = "BIRTH_DATE", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date birthDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id + " " + firstName + " " + lastName + " " + birthDate;
	}
	
	
	
}
