package com.service;

import org.springframework.http.ResponseEntity;

import com.model.User;

public interface Userservice {

	void registerUserInService(User user);

	User getsingleUserbyid(int id);

	/*
	 * ResponseEntity<?> updateUser(int id, User updateuser);
	 * 
	 * User updateUserdetails(int id, User updateduser);
	 */

	void delete(int id);

	Object getEmployeeById(int id);

	void updateEmployeeInfo(String name, String address, int age, String phonenumber, int id);

//	void updateUser(int id, User updateuser);

}
