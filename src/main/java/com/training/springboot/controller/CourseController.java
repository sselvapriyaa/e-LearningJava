package com.training.springboot.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//import org.aspectj.apache.bcel.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.training.springboot.model.Course;
//import com.training.springboot.model.Enrollment;

import com.training.springboot.repository.CourseRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    CourseRepository courseRepository;
    
    //Getting list of courses
    @GetMapping("/getCourses")  
   	public ResponseEntity<List<Course>> getCourses(){
   		List<Course> courses = new ArrayList<Course>();
   		courseRepository.findAll().forEach(courses::add);
   		//System.out.println(enrollments);
   		return new ResponseEntity<>(courses,HttpStatus.OK);
   	}
    
    //Adding new Course
    @PostMapping("/addCourse")
    public ResponseEntity<Course> addCourse(@RequestBody Course course){
    	Course _course = courseRepository.save(new Course(course.getCourseName(), course.getCourseResource(),
    			course.getCourseDesc(),course.getCourseFee()));
    	return new ResponseEntity<>(_course, HttpStatus.CREATED);
    	//return new ResponseEntity<Course>(_course, HttpStatus.CREATED);
    }
    
    //Getting Course By Id
    /*@GetMapping("/course/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable("id") Integer id){
    	Optional<Course> courseData = courseRepository.findById(id);
    	return new ResponseEntity<Course>(HttpStatus.OK);
    	   
    }*/
    
  //Getting Course By Id
    @GetMapping("/course/{id}")
	public ResponseEntity<Course> getCourseById(@PathVariable("id") Integer id){

		Optional<Course> courseData = courseRepository.findById(id);

		if(courseData.isPresent()) {
			return new ResponseEntity<>(courseData.get(),HttpStatus.OK);
		} 
		else
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
    
    //update course By Id
    @PutMapping("/course/{id}")
    public ResponseEntity<Course> updatecourse(@PathVariable("id") Integer id, @RequestBody Course course){
    	Optional<Course> courseData = courseRepository.findById(id);
    	if(courseData.isPresent()) {
    		//can be updated
    		Course _course = courseData.get();
    		_course.setCourseName(course.getCourseName());
    		_course.setCourseResource(course.getCourseResource());
    		_course.setCourseDesc(course.getCourseDesc());		
    		_course.setCourseFee(course.getCourseFee());
    		//Course updatedCourse = courseRepository.save(_course);
    		//return new ResponseEntity<Course>(updatedCourse,HttpStatus.OK);
    		return new ResponseEntity<>(courseRepository.save(_course),HttpStatus.OK);
    	}
    	else {
    		// course not present
    		//return new ResponseEntity<Course>(HttpStatus.NOT_FOUND);
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	}	
    }
    		/*@DeleteMapping("/course/{id}")
    		public ResponseEntity<Course> deleteCourse(@PathVariable("id") int id){
    			
    			courseRepository.deleteById(id);
    			return new ResponseEntity<Course>(HttpStatus.NO_CONTENT);
    			
    		}	*/
    

	// Deleting  Course By Id
	@DeleteMapping("/course/{id}")
	public ResponseEntity<Course> deletecourseById(@PathVariable("id") Integer id){

		try {
			courseRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

    
}
    

    
    

