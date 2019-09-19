package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.entity.User;
import com.service.SecurityService;
import com.service.UserService;
import com.validator.UserValidator;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private SecurityService securityService;
	@Autowired
	private UserValidator userValidator;
	
	@GetMapping("/registration")
	public String registration(Model model) {
		model.addAttribute("userForm", new User());
		return "student";
	}
	@PostMapping("/registration")
	public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model ) {
		userValidator.validate(userForm, bindingResult);
		if(bindingResult.hasErrors()) {
			return "registration";
		}
		userService.save(userForm);
		securityService.autologin(userForm.getUserName(), userForm.getPassWordConfirm());
		return "redirect:/student";
		
	}
	@GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }
	@GetMapping({"/","/student"})
	public String anyrole() {
		return "login";
	}
}
