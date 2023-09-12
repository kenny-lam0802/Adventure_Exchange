package com.kennylam.adventureexchange.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kennylam.adventureexchange.models.Equipment;
import com.kennylam.adventureexchange.models.User;
import com.kennylam.adventureexchange.services.EquipmentService;
import com.kennylam.adventureexchange.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class EquipmentController {
	
	
	@Autowired
	private EquipmentService equipmentService;
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/adventure")
	public String allEquipment(HttpSession session, Model model, RedirectAttributes flashAttributes) {
		model.addAttribute("equipment", equipmentService.allGear());
		
		if (session.getAttribute("currentUser") == null) {
			flashAttributes.addFlashAttribute("accessDenied", "Please Login or Register");
			return "redirect:/";
		}
		User currentUser = userService.findId((long)session.getAttribute("currentUser"));
		
		model.addAttribute("loggedInUser", currentUser);
		return "itemsTable.jsp";
	}
	
	@GetMapping("/adventure/create")
	public String addItem(HttpSession session, Model model, @ModelAttribute("gear") Equipment gear, RedirectAttributes flashAttributes) {
		if (session.getAttribute("currentUser") == null) {
			flashAttributes.addFlashAttribute("accessDenied", "Please Login or Register");
			return "redirect:/";
		}
		User currentUser = userService.findId((long)session.getAttribute("currentUser"));
		model.addAttribute("loggedInUser", currentUser);
		return "addItem.jsp";
	}
	
	@PostMapping("/adventure/create")
	public String processGearCreate(@Valid @ModelAttribute("gear") Equipment gear, BindingResult result) {
		if(result.hasErrors()) {
			return "addItem.jsp";
		}
		else {
			equipmentService.addGear(gear);
			return "redirect:/dashboard";
		}
		
	}
	
	@GetMapping("/adventure/{id}/view")
	public String viewEquipment(@PathVariable("id") Long id, Model model, HttpSession session, RedirectAttributes flashAttributes) {
		model.addAttribute("equipment", equipmentService.findGearId(id));
		
		if (session.getAttribute("currentUser") == null) {
			flashAttributes.addFlashAttribute("accessDenied", "Please Login or Register");
			return "redirect:/";
		}
		User currentUser = userService.findId((long)session.getAttribute("currentUser"));
		
		model.addAttribute("loggedInUser", currentUser);
		return "viewOne.jsp";
	}
	
	@GetMapping("/adventure/{id}/edit")
	public String editForm(@PathVariable("id") Long id, Model model, HttpSession session, RedirectAttributes flashAttributes) {
		if (session.getAttribute("currentUser") == null) {
			flashAttributes.addFlashAttribute("accessDenied", "Please Login or Register");
			return "redirect:/";
		}
		
		model.addAttribute("editGear", this.equipmentService.findGearId(id));
		return "editItem.jsp";
	}
	
	@PutMapping("/adventure/{id}/edit")
	public String processEdit(@Valid @ModelAttribute("editGear") Equipment equipmentEdit, BindingResult result) {
		if(result.hasErrors()) {
			return "editItem.jsp";
		}
		equipmentService.updateGear(equipmentEdit);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/adventure/delete/{id}")
	public String delete(@PathVariable("id") Long id, HttpSession session, RedirectAttributes flashAttributes) {
		if (session.getAttribute("currentUser") == null) {
			flashAttributes.addFlashAttribute("accessDenied", "Please Login or Register");
			return "redirect:/";
		}
		Equipment equipment = equipmentService.findGearId(id);
		equipmentService.deleteGear(equipment);
		return "redirect:/dashboard";
	}
}

