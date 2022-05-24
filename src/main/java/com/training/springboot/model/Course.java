package com.training.springboot.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "courses")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "COURSE_ID")
	private int courseId;
	
	@Column(name = "COURSE_NAME")
    private String courseName;
	 
    @Column(name = "COURSE_RESC")
    private String courseResource; 
    
    @Column(name = "COURSE_DESC")
    private String courseDesc;
    
    @Column(name = "COURSE_FEE")
    private double courseFee;
    
    @OneToMany(fetch=FetchType.EAGER, mappedBy = "course", cascade = CascadeType.ALL) 
    private Set<Enrollment> enrollment;
    
	public Course() {
		
	}
	
	public Course(String courseName, String courseResource, String courseDesc, double courseFee) {
		super();
		this.courseName = courseName;
		this.courseResource = courseResource;
		this.courseDesc = courseDesc;
		this.courseFee = courseFee;
	}
    
	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
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
	}

	public Set<Enrollment> getEnrollment() {
		return enrollment;
	}

	public void setEnrollment(Set<Enrollment> enrollment) {
		this.enrollment = enrollment;
	}


    
    
}