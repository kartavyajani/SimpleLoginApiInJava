package com.login.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController

public class UserController {
	@Autowired
    UserRepository userRepository;
//	else if(admindata.getUsername()==null || admindata.getUsername()==" " || admindata.getPassword()==null || admindata.getPassword()==" " )
	
	@PostMapping("/users/register")
    public Status registerUser( @Valid @RequestBody User newUser) {
        List<User> users = userRepository.findAll();  
        System.out.println("New user: " + newUser.toString());
        if(newUser.getUsername()=="" || newUser.getPassword()=="" || newUser.getUsername()==null || newUser.getPassword()==null)
        {
        return Status.FAILURE;	
        }
        else {           
        for (User user : users) {
            System.out.println("Registered user: " + newUser.toString());
            
         if (user.equals(newUser)) {
            System.out.println("User Already exists!");
             return Status.USER_ALREADY_EXISTS;

           // if (user.equals(newUser)) {
               // System.out.println("User Already exists!");
                //return Status.USER_ALREADY_EXISTS;
            }
        }  
        
        userRepository.save(newUser);        
        return Status.SUCCESS; 
        }
}
	
	
	  @PostMapping("/users/login")
	    public Status loginUser(@Valid @RequestBody User user) {
	        List<User> users = userRepository.findAll();
	        System.out.println("inside login");
	        if(user.getUsername()=="" || user.getPassword()=="" || user.getUsername()==null || user.getPassword()==null)
	        {
	        	 return Status.FAILURE;	
	        }
	        else {
	        	 for (User other : users) {
	 	            if (other.equals(user)) {
	 					user.setLoggedIn(true); 
	 	                System.out.println("logged in user: " + user.toString());	
	 	               userRepository.save(user);
		                return Status.SUCCESS;	
	        } }
	        	 return Status.FAILURE;
	        	       
	 	                     	        	 
	        } 
	       
	    }
	  
	  @PostMapping("/users/logout")
	    public Status logUserOut(@Valid @RequestBody User user) {
	        List<User> users = userRepository.findAll();

	        for (User other : users) {
	            if (other.equals(user)) {
					user.setLoggedIn(false); 
	                System.out.println("loged out user: " + user.toString());
	               userRepository.save(user);
	                return Status.SUCCESS;
	            }
	        }

	        return Status.FAILURE;
	    }

	    @DeleteMapping("/users/all")
	    public Status deleteUsers() {
	        userRepository.deleteAll();
	        return Status.SUCCESS;
	    }
}	
	
	
	
	

