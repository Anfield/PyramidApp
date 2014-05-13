package com.secureapp.rap.controller;

import com.secureapp.rap.domain.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SecureController {

    @ModelAttribute
    public User populateCurrentUser(){
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

	@RequestMapping(value = "/secure/", method = RequestMethod.GET)
	public String secure() {
		return "secure";
	}
	
}
