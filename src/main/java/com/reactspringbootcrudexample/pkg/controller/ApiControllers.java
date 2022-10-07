package com.reactspringbootcrudexample.pkg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.reactspringbootcrudexample.pkg.models.User;
import com.reactspringbootcrudexample.pkg.repository.UserRepo;


@Controller
//if we use Controller here, use @ResponseBody in get methods.
//because @ResponseBody annotation tells a controller that obj returned is 
//automatically serailized into json and passed into HttpResponse object

//if we use @RestController here, no need to use @ResponseBody, its inbuilt in this.

public class ApiControllers {
	
	@Autowired
	private UserRepo userrepo; 
	
	@GetMapping(value = "/")
	public String getPage() {
		return "Welcome";
	}
	
	@GetMapping(value = "/getallusers")
	@ResponseBody
	public List<User> getUsers(){
		return userrepo.findAll();
	}
	
	@PostMapping(value = "/saveuser")
	public String saveUser(@RequestBody User user) {
	userrepo.save(user);
	return "User saved";
	}
	
	@PutMapping(value = "/updateuser/{id}")
	public String updateUser(@PathVariable long id, @RequestBody User user) {
		User firstgetuser = userrepo.findById(id).get();
		
		firstgetuser.setFirstName(user.getFirstName());
		firstgetuser.setLastName(user.getLastName());
		firstgetuser.setAge(user.getAge());
		firstgetuser.setOccupation(user.getOccupation());
		userrepo.save(firstgetuser);
		return "User Updated";
		
	}
}
