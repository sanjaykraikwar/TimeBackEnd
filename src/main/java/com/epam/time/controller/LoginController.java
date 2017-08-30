package com.epam.time.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.epam.time.model.User;
import com.epam.time.repository.UserRepository;



@RestController
public class LoginController {
	
	@Autowired
	UserRepository userRepository;
	
	@RequestMapping("/login")
	public List<User> sayHello() {
		return userRepository.findByUserNameAndPassword("sanjay","kumar");
	}
	
	@RequestMapping("/add") // Map ONLY GET Requests
	public @ResponseBody String addNewUser (@RequestParam String name
			, @RequestParam String password) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		User n = new User();
		n.setUserName(name);
		n.setPassword(password);
		userRepository.save(n);
		return "Saved";
	}
	
	@RequestMapping("/get") 
	public @ResponseBody User getUserByNameAndPassword (String name, String password) {
		
		List<User> users= userRepository.findByUserNameAndPassword(name,password);
		User user=null;
		if(users.size()>0)
			 user= users.get(0);
		return user;
	}

	 @CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		// This returns a JSON or XML with the users
		return userRepository.findAll();
	}


}
