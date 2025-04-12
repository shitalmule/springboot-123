package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.model.User;
import com.service.Userservice;

import ch.qos.logback.classic.Logger;

@RestController
@RequestMapping("/exponent/api")
public class Usercontroller {
	@Autowired
	private Userservice us;

	@PostMapping(value = "/adduser")
	public ResponseEntity<?> registerUser(@RequestBody User user) {
		us.registerUserInService(user);
		return new ResponseEntity("User added", HttpStatus.OK);
	}

	@GetMapping("/getUsingid/{id}")
	public ResponseEntity<?> getusingid(@PathVariable("id") int id) {

		us.getsingleUserbyid(id);
		return null;
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteusingid(@PathVariable("id")int id) {
		us.delete(id);
		return  new ResponseEntity("User deleted successfully",HttpStatus.OK);

		
	}
	@PutMapping("/updateEmployee/{id}")
	public ResponseEntity<?> updateUser(@PathVariable("id") int id, @RequestParam("name") String name,
			@RequestParam("address") String address, @RequestParam("age") int age,
			@RequestParam("phonenumber") String phonenumber) {

		if (us.getEmployeeById(id) != null) {
			us.updateEmployeeInfo(name, address, age, phonenumber, id);
			return new ResponseEntity("User details updated successfully!", HttpStatus.OK);
		} else {
			return new ResponseEntity("User with ID " + id + " not found!", HttpStatus.BAD_REQUEST);
		}
	}
}
	

