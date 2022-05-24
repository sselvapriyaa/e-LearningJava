package com.training.springboot.controller;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RestController;

//import com.training.springboot.model.Course;
import com.training.springboot.model.Enrollment;
import com.training.springboot.model.User;
import com.training.springboot.repository.EnrollmentRepository;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/enroll")
public class EnrollmentController {
	
    @Autowired
    EnrollmentRepository enrollmentRepository;

    //Getting list of enrollments
    @GetMapping("/getEnrollment")  
   	//public ResponseEntity<List<Enrollment>> getCourses(){
    public ResponseEntity<List<Enrollment>> getEnrollment(){
   		List<Enrollment> enrollments = new ArrayList<Enrollment>();
   		enrollmentRepository.findAll().forEach(enrollments::add);
   		//System.out.println(enrollments);
   		return new ResponseEntity<>(enrollments,HttpStatus.OK);
   	}
    
    //1.Adding new Enrollment
    /*@PostMapping("/addEnrollment")
    public ResponseEntity<Enrollment> addEnrollment(@RequestBody Enrollment enrollment){
    	Enrollment _enrollment = enrollmentRepository.save(new Enrollment(enrollment.getCourseName(), enrollment.getCourseResource(),
    			enrollment.getCourseDesc(),enrollment.getCourseFee()));
    	return new ResponseEntity<Enrollment>(_enrollment, HttpStatus.CREATED);
    }*/
    
  //2.Adding new Enrollment
     /*@PostMapping("/addEnrollment")
     public ResponseEntity<Enrollment> addEnrollment(@RequestBody Enrollment enrollment){
 		
 		Enrollment _enrollment = enrollmentRepository.save(enrollment);

 		return new ResponseEntity<>(_enrollment, HttpStatus.CREATED);

 	}*/
  //Adding new Enrollment
    @PostMapping("/addEnrollment")
    public ResponseEntity<Enrollment> addEnrollment(@RequestBody Enrollment enrollment){
    	Enrollment _enrollment = enrollmentRepository.save(new Enrollment(enrollment.getCourseId(), enrollment.getEnrollmentID()));
    	return new ResponseEntity<Enrollment>(_enrollment, HttpStatus.CREATED);
    }
    
    
  //Getting course By Id
  //  @GetMapping("/course/{id}")
   /* public ResponseEntity<Enrollment> getCourseById(@PathVariable("id") Integer id){
    	Optional<Enrollment> enrollmentData = enrollmentRepository.findById(id);
    	return new ResponseEntity<Enrollment>(HttpStatus.OK);
    	   
    }*/
    
   //Getting User By Id
 	@GetMapping("/enrollment/{id}")
 	public ResponseEntity<Enrollment> getEnrollmentById(@PathVariable("id") Integer id){

 		Optional<Enrollment> enrollmentData = enrollmentRepository.findById(id);

 		if(enrollmentData.isPresent()) {
 			return new ResponseEntity<>(enrollmentData.get(),HttpStatus.OK);
 		} 
 		else
 		{
 			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
 		}
 	}
  //update a course
    /*@PutMapping("/course/{id}")
    public ResponseEntity<Enrollment> updateCourse(@PathVariable("id") int id, @RequestBody Course course){
    	Optional<Enrollment> courseData = enrollmentRepository.findById(id);
    	if(courseData.isPresent()) {
    		//can be updated
    		Enrollment _course = courseData.get();
    		_course.setCourseName(course.getCourseName());
    		_course.setCourseResource(course.getCourseResource());
    		_course.setCourseDesc(course.getCourseDesc());		
    		_course.setCourseFee(course.getCourseFee());
    		Enrollment updatedCourse = enrollmentRepository.save(_course);
    		return new ResponseEntity<Enrollment>(updatedCourse,HttpStatus.OK);
    	}
    	else {
    		// course not present
    		return new ResponseEntity<Enrollment>(HttpStatus.NOT_FOUND);
    	}	
    }*/

	//updating  User By Id
	@PutMapping("/enrollment/{id}")
	public ResponseEntity<Enrollment> updateEnrollment(@PathVariable("id") Integer id,@RequestBody Enrollment enrollment){

		Optional<Enrollment> enrollmentData = enrollmentRepository.findById(id);

		if(enrollmentData.isPresent()) {
			Enrollment usr = enrollmentData.get();
//			usr.setUserName(enrollment.getUserName());
//			usr.setEmail(enrollment.getEmail());
//			usr.setAddress(enrollment.getAddress());
			
			return new ResponseEntity<>(enrollmentRepository.save(usr),HttpStatus.OK);
		} 
		else
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
 	
    	/*	@DeleteMapping("/course/{id}")
    		public ResponseEntity<Enrollment> deleteCourse(@PathVariable("id") int id){
    			
    			enrollmentRepository.deleteById(id);
    			return new ResponseEntity<Enrollment>(HttpStatus.NO_CONTENT);
    			
    		}	*/	
    		
	// Deleting Enrollment By Id
		@DeleteMapping("/enrollment/{id}")
		public ResponseEntity<User> deleteEnrollmentById(@PathVariable("id") Integer id){

			try {
				enrollmentRepository.deleteById(id);
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			catch(Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
    
    
    
    
}

    
    
    
    
    
