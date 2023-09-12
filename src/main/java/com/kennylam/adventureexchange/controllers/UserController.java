package com.kennylam.adventureexchange.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kennylam.adventureexchange.models.LoginUser;
import com.kennylam.adventureexchange.models.User;
import com.kennylam.adventureexchange.services.EquipmentService;
import com.kennylam.adventureexchange.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private EquipmentService equipmentService;
	
	@GetMapping("/")
	public String login(@ModelAttribute("loginUser") LoginUser user) {
		return "index.jsp";
	}
	
	@PostMapping("/login")
	public String processLogin(@Valid @ModelAttribute("loginUser") LoginUser loginUser, BindingResult result, HttpSession session) {
		
		Boolean isValid = userService.login(result, loginUser, session);
		if(result.hasErrors() || !isValid) {
			return "index.jsp";
		}
		return "redirect:/dashboard";
	}
	
	@GetMapping("/register")
	public String register(@ModelAttribute("newUser") User user) {
		return "register.jsp";
	}
	
	@PostMapping("/registration/process")
	public String registrationProcess (@Valid @ModelAttribute("newUser") User user, BindingResult result, Model model, HttpSession session) {
		Boolean isValid = userService.isValid(result, user,session);
		
		if(result.hasErrors() || isValid != true) {
			return "register.jsp";
		}
		
		User createdUser = userService.register(user);
		session.setAttribute("currentUser", createdUser.getId());
		
		return "redirect:/dashboard";
	}
	
	@GetMapping("/dashboard")
	public String homepage(HttpSession session, Model model, RedirectAttributes flashAttributes) {
		model.addAttribute("equipment", equipmentService.allGear());
		
		if (session.getAttribute("currentUser") == null) {
			flashAttributes.addFlashAttribute("accessDenied", "Please Login or Register");
			return "redirect:/";
		}
		
		User currentUser = userService.findId((long)session.getAttribute("currentUser"));
		model.addAttribute("loggedInUser", currentUser);
		return "dashboard.jsp";
	}
	
	@GetMapping("/logout")
	public String signout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
}
