package tn.esprit.spring.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.service.UserService;
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class UserController {
	@Autowired
	UserService userservice;
	//creating a get mapping that retrieves all the user detail from the database  
	@CrossOrigin(origins = "*", allowedHeaders = "*")

	@GetMapping("/users")
	private List<User>getAllUser()
	{
		List<User> users= userservice.getAllUser();
		return users;
	}
	//creating a get mapping that retrieves the detail of a specific user 
	@CrossOrigin(origins = "*", allowedHeaders = "*")

	@GetMapping("/user/{userid}")
	private User getUser(@PathVariable("userid")Long userid)
	{
		User u= userservice.retrieveUser(userid);
		return u;
	}
	//creating a delete mapping that deletes a specified book  
	@CrossOrigin(origins = "*", allowedHeaders = "*")

	@DeleteMapping("/remove-user/{userid}")
	private void DeleteUser(@PathVariable("userid")Long userid)
	{
		userservice.deleteUser(userid);
	}
	//creating post mapping that post the book detail in the database  
	@CrossOrigin(origins = "*", allowedHeaders = "*")

	@PostMapping("/saveUser")  
	private User saveUser(@RequestBody User user)   
	{  
	userservice.addUser(user);  
	return user;
	} 
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")

	@PutMapping("/blockUser/{id}")  
	private void blockUser(@PathVariable("id") Long id)   
	{  
	userservice.blockUser(id); 
	
	} 
	
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")

	@PutMapping("/unblockUser/{id}")  
	private void unblockUser(@PathVariable("id") Long id)   
	{  
	userservice.unblockUser(id); 
	
	}
	
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")

	//creating put mapping that updates the book detail   
	@PutMapping("/updateUser")  
	private User update(@RequestBody User user)   
	{  
	userservice.updateUser(user);  
	return user;  
	}  
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")

	
	@GetMapping("/find-user-by-email/{email}")
    public Optional<User> find_user_by_email(@PathVariable("email") String email){
        return userservice.FindUserByEmail(email);
    }
	
	
	@GetMapping("/filter-by-domain/{domain}")
    public List<User> filterByDomain(@PathVariable("domain") String domain){
        return userservice.filterByDomain(domain);
    }
	
	
	@GetMapping("/orderByName")
    public List<User> orderByName(){
        return userservice.orderByName();
    }

	 @PostMapping("/authenticate-user")
	    public User Authenticate(@RequestBody User u){
	        return  userservice.Authenticate(u.getEmail(),u.getPassword());
	    }

	    @PostMapping("/reset-password-user")
	    public User ResetPassword(@RequestBody User u){
	        return  userservice.ResetPassword(u.getEmail(),u.getPassword());
	    }

	    @PostMapping("/verify-password-user")
	    public boolean verifyPassword(@RequestBody User u){
	        return  userservice.verifyPassword(u.getEmail(),u.getPassword());
	    }
	
	@GetMapping("/nbr-Travelers")
	@ResponseBody
	public int numbreTravelers() {
	return userservice.nbrTravelers();
	}
	
	@GetMapping("/nbr-Employee")
	@ResponseBody
	public int numbreEmployee() {
	return userservice.nbrEmployee();
	}
	
	@GetMapping("/nbr-Entreprise")
	@ResponseBody 
	public int numbreEntreprise() {
	return userservice.nbrEntreprise();
	}
}
