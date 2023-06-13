package com.mongodb.main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.entities.User;
import com.mongodb.services.UserRepo;

@RestController
public class MyController {

	@RequestMapping("/")
	public String hello() {
		return "hello there";
	}

	@Autowired
	private UserRepo urepo;
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveUser(@RequestBody User user) {
		User user2 = this.get();
		if(user2 == null) {
			urepo.insert(user);
		}else {
			user.setId(user2.getId()+1);
			urepo.insert(user);
		}
		return "done";
	}
	
	@RequestMapping("/get")
	public User get() {
		List<User> users = new ArrayList<>();
		users = urepo.findAll();
		
		int index = users.size();
		if(index <=0) {
			return null;
		}
		return users.get(index-1);
	}
	@RequestMapping("/get/{name}")
	public User getOne(@PathVariable("name") String name ) {
		return urepo.findByName(name);
	}
}
