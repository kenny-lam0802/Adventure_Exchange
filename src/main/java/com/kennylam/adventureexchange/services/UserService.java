package com.kennylam.adventureexchange.services;

import java.util.ArrayList;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.kennylam.adventureexchange.models.LoginUser;
import com.kennylam.adventureexchange.models.User;
import com.kennylam.adventureexchange.repositories.UserRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public ArrayList<User>allUsers(){
		return userRepository.findAll();
	}
	
	public User register(User newUser) {
		return userRepository.save(newUser);
	}
	
	public User findId(Long id) {
		return userRepository.findById(id).orElse(null);
	}
	
	public Boolean isValid(BindingResult result, User user, HttpSession session) {
		//searching DB for already existing Email for registration
		User existingUser = userRepository.findByEmail(user.getEmail()).orElse(null);
		
		if (existingUser != null) {
			result.rejectValue("email", "exists", "Account with same Email already exists");
			return false;
		}
		// Checking passwords match
		else if(!user.getPassword().equals(user.getConfirm())) {
			result.rejectValue("confirm", "Matches", "Confirm password must match password"); //"field", "name of validation", "message"
			return false;
		}
		//bcrypt to hash passwords in DB
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashed);
		return true;
	}
	
	public Boolean login(BindingResult result, LoginUser loginUser, HttpSession session) {
		
		if(result.hasErrors()) {
			return false;
		}
		
		//Email exists in DB for login?
		User userInDb = userRepository.findByEmail(loginUser.getEmail()). orElse(null);
		
		if(userInDb == null) {
			result.rejectValue("email", "invalid", "Invalid Login");
			return false;
		}
		
		Boolean found = BCrypt.checkpw(loginUser.getPassword(),userInDb.getPassword());
		if(!found) {
			result.rejectValue("password", "invalid", "Invalid Login");
			return false;
		}
		
		session.setAttribute("currentUser", userInDb.getId());
		
		return true;
	}

}
