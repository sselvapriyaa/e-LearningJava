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
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.training.springboot.model.User;
import com.training.springboot.repository.UserRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/newuser")
//@RequestMapping("/api")
public class UserController {		
		@Autowired
	    UserRepository userRepository;
	
		
		//retrieve all students from database
		@GetMapping("/getAllUsers")
		public ResponseEntity<List<User>> getAllUsers(){
			List<User> users = new ArrayList<User>();
			userRepository.findAll().forEach(users::add);
			System.out.println(users);
			return new ResponseEntity<>(users,HttpStatus.OK);
		}
		/*@GetMapping("/getAllUsers")
		public ResponseEntity<List<User>> getAllUsers(@RequestParam(required = false) String firstName){
			try {
				List<User> users = new ArrayList<User>();
				
				if(firstName == null)
					userRepository.findAll().forEach(users::add);
					else 
						userRepository.findByFirstName(firstName).forEach(users::add);
					
					if (users.isEmpty()) {
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
				System.out.println(users);
				return new ResponseEntity<>(users,HttpStatus.OK);
			}catch (Exception e) {
				return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
				
			}	
			
		}*/
		//insert new student into database
		//@PostMapping("/add")
		//public Student addStudent(@RequestBody Student student) {
		//	return studentRepository.save(student);
		
			//Adding new User
		    /*@PostMapping("/addNewUser")
		    public ResponseEntity<User> addUser(@RequestBody User user){
		    	//do for all non-mandatory fields
		    	String firstName = "";
		    	String lastName = "";
		    	String regDate = "";
		    	String address = "";
		    	int phoneNumber;
		    	String userName = "";
		    	String email = "";
		    	String password = "";
		    	String role = ""; 
		    	
		    	if(user.getFirstName()!= null || 
		    			user.getFirstName() != "") {
		    		firstName = user.getFirstName();
		    	}
		    	if(user.getLastName()!= null || 
		    			user.getLastName() != "") {
		    		lastName = user.getLastName();
		    	}
		    	if(user.getRegDate()!= null || 
		    			user.getRegDate() != "") {
		    		regDate = user.getRegDate();
		    	}
		    	if(user.getEmail()!= null || 
		    			user.getEmail() != "") {
		    		email = user.getEmail();
		    	}
		    	if(user.getAddress()!= null || 
		    			user.getAddress() != "") {
		    		address = user.getAddress();
		    	}
		    	if(user.getUserName()!= null || 
		    			user.getUserName() != "") {
		    		password = user.getPassword();
		    	}
		    	if(user.getPassword()!= null || 
		    			user.getPassword() != "") {
		    		password = user.getPassword();
		    	}
		    	if(user.getRole()!= null || 
		    			user.getRole() != "") {
		    		role = user.getRole();
		    	}
		    	
		    	User _user = userRepository.save(new User(user.getFirstName(),user.getLastName(),
		    			user.getRegDate(),user.getAddress(),user.getPhoneNumber(),
		    			user.getEmail(),user.getUserName(),user.getPassword(),user.getRole()));
		    	return new ResponseEntity<>(_user, HttpStatus.CREATED);

		    }*/
		
		//Adding new User
	    /*@PostMapping("/addNewUser")
	    public ResponseEntity<User> addUser(@RequestBody User user){
	    	try {
	    				
	    		User _user = userRepository.save(new User(user.getFirstName(), user.getLastName(), user.getRegDate(), user.getEmail(), user.getPhoneNumber(), user.getAddress(), user.getUserName(), user.getPassword(), user.getRole()));
	    		return new ResponseEntity<>(_user, HttpStatus.CREATED);
	    	}catch(Exception e) {
	    		return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
				
	    	}
			
		
	    }*/
	  //Adding new User
	    @PostMapping("/addNewUser")
	    public ResponseEntity<User> addUser(@RequestBody User user){
	    	try {
	    		if(user.getLastName() == null || user.getLastName().isEmpty()){
					
					//return new ResponseEntity<>(HttpStatus. NO_CONTENT);
					return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	    		}
					System.out.println(user);
	    				
	    		User _user = userRepository.save(new User(user.getFirstName(), user.getLastName(), user.getRegDate(), user.getEmail(), user.getPhoneNumber(), user.getAddress(), user.getUserName(), user.getPassword(), user.getRole()));
	    		return new ResponseEntity<>(_user, HttpStatus.CREATED);
	    	}catch(Exception e) {
	    		return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
				
	    	}
			
		
	    }
		    	//Getting User By Id
		       @GetMapping("/user/{id}")
		        public ResponseEntity<User> getStudentId(@PathVariable("id") int id) throws Exception{
		        	Optional<User> user = userRepository.findById(id);
		        	if(user == null) {
		        	       throw new Exception("Invalid user id : " + user);
		        	    }
		        	return new ResponseEntity<User>(HttpStatus.OK);			
				        	
		        }
		    //Getting User By Id
		   /* @GetMapping("/user/{id}")
		    public ResponseEntity<User> getStudentId(@PathVariable("id") int id){
	        	Optional<User> userData = userRepository.findById(id);
	        	
	        	if(userData.isPresent()){
	        		return new ResponseEntity<User>(userData.get(),HttpStatus.OK);
	        	    }else {
	        	return new ResponseEntity<>(HttpStatus.NOT_FOUND);	
	        	    }
			        	
	        }*/
		           
		        //update user
		       /* @PutMapping("/user/{id}")
		        public ResponseEntity<User> updateUser(@PathVariable("id") int id, @RequestBody User user){
		        	Optional<User> userData = userRepository.findById(id);
		        	if(userData.isPresent()) {
		        		//can be updated
		        		User _user = userData.get();
		        		_user. setFirstName(user.getFirstName());
		        		_user.setLastName(user.getLastName());	
		        		_user.setRegDate(user.getRegDate());
		        		_user.setAddress(user.getAddress());
		        		_user.setPhoneNumber(user.getPhoneNumber());
		        		_user.setUserName(user.getUserName());
		        		_user.setEmail(user.getEmail());
		        		_user.setPassword(user.getPassword());
		        		_user.setRole(user.getRole() );
		        		User updatedUser = userRepository.save(_user);
		        		return new ResponseEntity<User>(updatedUser,HttpStatus.OK);
		        	}
		        
		        	else {
		        		// course not present
		        		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		        			        
		        	}
		        }*/
		    //update user
		        @PutMapping("/user/{id}")
		        public ResponseEntity<User> updateUser(@PathVariable("id") int id, @RequestBody User user){
		        	Optional<User> userData = userRepository.findById(id);
		        	if(userData.isPresent()) {
		        		//can be updated
		        		User _user = userData.get();
		        		_user. setFirstName(user.getFirstName());
		        		_user.setLastName(user.getLastName());	
		        		_user.setRegDate(user.getRegDate());
		        		_user.setEmail(user.getEmail());
		        		_user.setPhoneNumber(user.getPhoneNumber());
		        		_user.setAddress(user.getAddress());
		        		_user.setUserName(user.getUserName());
		         		_user.setPassword(user.getPassword());
		        		_user.setRole(user.getRole());
		        		User _userData = userRepository.save(_user);
		        		return new ResponseEntity<User>(_userData,HttpStatus.OK);
		        		//return new ResponseEntity<>(userRepository.save(_user),HttpStatus.OK);
		        }else {
		        	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		        }
		        }
		        	// delete a user by id
		    		/*@DeleteMapping("/user/{id}")
		    		public ResponseEntity<User> deleteUser(@PathVariable("id") int id){
		    			
		    			userRepository.deleteById(id);
		    			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
		    			
		    		}	*/
		     // delete a user by id
		        @DeleteMapping("/user/{id}")
	    		public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") int id){
	    			try {
	    			userRepository.deleteById(id);
	    			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    			
	    		}catch (Exception e) {
	    			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    		}
		        }
		        
		        /*@DeleteMapping("/user/{id}")
	    		public ResponseEntity<User> deleteUser(@PathVariable("id") int id){
	    			try {
	    			userRepository.deleteById(id);
	    			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	    			
	    		}catch (Exception e) {
	    			return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
	    		}
		        }*/
	    			
	    			
	    		@DeleteMapping("/user")
	 	    		public ResponseEntity<HttpStatus> _deleteUser(){
	 	    			try {
	 	    			userRepository.deleteAll();
	 	    			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	 	    			
	 	    		}catch (Exception e) {
	 	    			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	 	    		}
		      
		        }
	    		@GetMapping("/getusers")
	    		public ResponseEntity<List<User>> findByrole(){
	    			try {
	    				List<User> users = userRepository.findByRole(true);
	    				
	    				if(users.isEmpty()){
	    					//userRepository.findAll().forEach(users::add);
	    					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    				}
	    				System.out.println(users);
	    				return new ResponseEntity<>(users,HttpStatus.OK);
	    			}catch (Exception e) {
	    				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    			}
	    			}
	    		@GetMapping("/loginUser")
	    		public ResponseEntity<List<User>> loginUser(){
	    			List<User> users = new ArrayList<User>();
	    			userRepository.findAll().forEach(users::add);
	    			System.out.println(users);
	    			return new ResponseEntity<>(users,HttpStatus.OK);
	    		}
	    		//@PostMapping("/loginUser")
	    		/*public ResponseEntity<User> loginUser(@RequestBody User user){
	    			System.out.println("user" +user);
	    			ResponseEntity<User> rs = new ResponseEntity<>(HttpStatus.CREATED);
	    			List<User> userData = userRepository.findAll();
	    			
	    			for(User usr:userData) {
	    				
	    				if(usr.getUserName().equalsIgnoreCase(user.getUserName()) &&
	    						usr.getEmail().equalsIgnoreCase(user.getEmail()) &&
	    						usr.getPassword().equals(user.getPassword()))
	    				{ 
	    					rs = new ResponseEntity<>(usr, HttpStatus.OK);
	    					
	    				} else
	    				{
	    					ResponseEntity.status(HttpStatus.NOT_FOUND);
	    				}
	    			}
					return rs;
	    			
	    		}*/
	    		
		
	    		
	    		}

		    	
		        

		 
		    		
		

