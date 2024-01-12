package com.example.demo.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;

@Service
public interface UserService {
	
	 Customer getCustomerByPhoneNumber(String phoneNumber);
	    String generateOTP(Customer customer);
	    boolean verifyOTP(String phoneNumber, String otp);
	}


