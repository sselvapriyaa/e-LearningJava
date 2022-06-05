package com.training.springboot.model;

import java.util.Set;

//import java.util.Set;

//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
//import javax.persistence.OneToMany;
import javax.persistence.Table;

//import org.springframework.beans.factory.annotation.Required;

@Entity
@Table(name = "user_03")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	

	@Column(name = "USER_ID", unique = true)
	
	//@Column(name = "userId", unique = true)
	//@Column(name = "userId")
	private int userId;
	

	@Column(name = "firstName", nullable = false)
    private String firstName;
	
	@Column(name = "lastName")
    private String lastName; 
	
	@Column(name = "regDate")
    private String regDate;
	
	@Column(name = "email")
    private String email;
	
	@Column(name = "phoneNumber")
    private long phoneNumber;
	
	@Column(name = "address")
    private String address;
	
	@Column(name = "userName")
    private String userName;
	
	@Column(name = "password", nullable = false)
    private String password;
	
	@Column(name = "role")
    private String role;
	
	//@OneToMany(fetch = FetchType.EAGER,mappedBy = "user", cascade = CascadeType.ALL)
	//private Set<Feedback> feedback;
	
	//@OneToMany(fetch = FetchType.EAGER,mappedBy = "user", cascade = CascadeType.ALL)
	@ManyToMany(targetEntity = Enrollment.class)
	private Set<Enrollment> enrollment;
	
	public User() {
		
	}

	/**
	 * @param firstName
	 * @param lastName
	 * @param regDate
	 * @param email
	 * @param phoneNumber
	 * @param address
	 * @param userName
	 * @param password
	 * @param role
	 */
	public User(String firstName, String lastName, String regDate, String email, long phoneNumber, String address,
			String userName, String password, String role) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.regDate = regDate;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.userName = userName;
		this.password = password;
		this.role = role;
	}
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	/*public Set<Feedback> getFeedback() {
		return feedback;
	}
	
	public void setFeedback(Set<Feedback> feedback) {
		this.feedback = feedback;
	}*/

	/*public Set<Enrollment> getEnrollment() {
		return enrollment;
	}

	public void setEnrollment(Set<Enrollment> enrollment) {
		this.enrollment = enrollment;
	}*/
	

}
