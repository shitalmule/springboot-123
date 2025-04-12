package com.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.DTO.UserDTO;
import com.Repo.Userrepo;
import com.model.User;

@Service
public class userserviceimpl implements Userservice {
	@Autowired
	private Userrepo ur;
	Logger logger = LoggerFactory.getLogger(Userservice.class);


	@Transactional
	public void registerUserInService(User user) {
		if (user != null) {
			ur.save(user);
			System.out.println("Success");

		} else {
			System.out.println("user is null");
		}

	}

	@Override
	public User getsingleUserbyid(int id) {
		UserDTO ud = new UserDTO();
		User user = ur.findById(id).get();
		if (user != null) {
			
			

		} else {
			return null;

		}
		return null;
	}

	
	@Override
	public void delete(int id) {
		if (ur.existsById(id)) {
			ur.deleteById(id);
	logger.info("User deleted successfully:id{}",id);
			
		} else {
			logger.error("User deleted succesfully : id {}",id);;

		}
	
		
	}

	@Override
	public Object getEmployeeById(int id) {
	
			return ur.findById(id).orElse(null);
	}

	@Override
	public void updateEmployeeInfo(String name, String address, int age, String phonenumber, int id) {
		Optional<User> UserOptional = ur.findById(id);
		if (UserOptional.isPresent()) {
			User user = UserOptional.get();
			
						ur.save(user); 
		}
		
	}

	
}
