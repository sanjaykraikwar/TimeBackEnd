package com.epam.time;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.epam.time.model.User;
import com.epam.time.model.Contact;
import com.epam.time.model.Coupon;
import com.epam.time.repository.UserRepository;

import io.swagger.annotations.ApiOperation;

import com.epam.time.repository.ContactRepository;
import com.epam.time.repository.CouponRepository;

@RestController
public class LoginController {
	
	@Autowired
	CouponRepository couponRepository;
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	ContactRepository contactRepository;
	
	@ApiOperation(value = "/login", notes="login ",nickname = "login")
	@GetMapping("/login")
	public List<User> sayHello() {
		return userRepository.findByUserNameAndPassword("sanjay","kumar");
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value="/saveUser",headers = "Accept=application/json") // Map ONLY GET Requests
	
	public @ResponseBody String addNewUser (String userName, String password) {
		

		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);
		user.setEnabled(true);
		userRepository.save(user);
		return "Saved";
	}
	
	 @CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/authUser") 
	public @ResponseBody User getUserByNameAndPassword (String userName, String password) {
		
		List<User> users= userRepository.findByUserNameAndPassword(userName,password);
		User user=null;
		if(users.size()>0)
			 user= users.get(0);
		return user;
	}

	 @CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		// This returns a JSON or XML with the users
		return userRepository.findAll();
	}
	 
	 @CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value="/saveContact",headers = "Accept=application/json" ) 	 
	public @ResponseBody String saveContact (@RequestBody Contact contact) {
	
		contactRepository.save(contact);
		return "Saved";
	}
	 
	 @CrossOrigin(origins = "http://localhost:4200")
		@GetMapping("/contacts")
		public @ResponseBody Iterable<Contact> getAllContacts() {
			
			return contactRepository.findAll();
		}
	 
	 @CrossOrigin(origins = "http://localhost:4200")
		@GetMapping("/coupon")
		public @ResponseBody String saveCoupon() {
			
		 Coupon coupon =new  Coupon();
		 coupon.setId(UUID.randomUUID().toString());
		 coupon.setAuthor("adas");
		 coupon.setCouponDescription("123");
		 couponRepository.save(coupon);
			return "added";
		}


}
