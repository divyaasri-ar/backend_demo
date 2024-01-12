package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.AdminCredentials;
import com.example.demo.service.AdminAuthenticationService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
	private final AdminAuthenticationService authService;
	
	@Autowired
	public AdminController(AdminAuthenticationService authService)
	{
		this.authService=authService;
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> loginAdmin(@RequestBody AdminCredentials adminCredentials)
	{
		if(authService.authenticateAdmin(adminCredentials.getEmail(), adminCredentials.getPassword()))
		{
			return ResponseEntity.ok("Login Successful");
		}
		else
		{
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Credentials");
		}
	}

}
