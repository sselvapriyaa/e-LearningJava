package com.training.springboot.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "enrollment")
public class Enrollment {
	
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ENROLL_ID") 
    private int enrollmentID;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private User user;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "COURSE_ID")
    private Course course;
    
    @Column(name = "USER_ID", insertable = false, updatable = false)
    //@Column(name = "USER_ID")
    private int userId;
    

    @Column(name = "COURSE_ID", insertable = false, updatable = false)
    //@Column(name = "COURSE_ID")
    private int courseId;
    
   
    /*private String courseName;
    private String courseResource;  
    private String courseDesc;
    private double courseFee;*/
    
	public Enrollment() {
	
	}


	/**
	 * @param userId
	 * @param courseId
	 */
	
	//public Enrollment( User user, Course course) {
	public Enrollment(int userId, int courseId) {
		super();
		this.userId = userId;
		this.courseId = courseId;
	}


	public int getEnrollmentID() {
		return enrollmentID;
	}


	public void setEnrollmentID(int enrollmentID) {
		this.enrollmentID = enrollmentID;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Course getCourse() {
		return course;
	}


	public void setCourse(Course course) {
		this.course = course;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public int getCourseId() {
		return courseId;
	}


	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	
	
	

	/*public Enrollment(String courseName, String courseResource, String courseDesc, double courseFee) {
		super();
		this.courseName = courseName;
		this.courseResource = courseResource;
		this.courseDesc = courseDesc;
		this.courseFee = courseFee;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseResource() {
		return courseResource;
	}

	public void setCourseResource(String courseResource) {
		this.courseResource = courseResource;
	}

	public String getCourseDesc() {
		return courseDesc;
	}

	public void setCourseDesc(String courseDesc) {
		this.courseDesc = courseDesc;
	}

	public double getCourseFee() {
		return courseFee;
	}

	public void setCourseFee(double courseFee) {
		this.courseFee = courseFee;
	}*/
	
	

   
}
