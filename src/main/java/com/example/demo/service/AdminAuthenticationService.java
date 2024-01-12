package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.AdminCredentials;
import com.example.demo.repository.AdminCredentialsRepository;

@Service
public class AdminAuthenticationService {
	private final AdminCredentialsRepository repository;
	
	@Autowired
	public AdminAuthenticationService(AdminCredentialsRepository repository)
	{
		this.repository=repository;
	}
	
	public boolean authenticateAdmin(String email, String password)
	{
		AdminCredentials adminCredentials=repository.findByEmail(email);
		return adminCredentials != null && adminCredentials.getPassword().equals(password);
	}

}
