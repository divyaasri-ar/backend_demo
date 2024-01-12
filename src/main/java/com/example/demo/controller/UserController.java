package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.UserService;
import com.example.demo.model.Customer;
import com.example.demo.model.OtpVerificationRequest;

@RestController
@RequestMapping("/api")
public class UserController {
	// UserController.java (Controller)
	   @Autowired
	    private UserService userService;

	    @PostMapping("/generate-otp")
	    public ResponseEntity<String> generateOTP(@RequestBody String phoneNumber) {
	        Customer customer = userService.getCustomerByPhoneNumber(phoneNumber);
	        if (customer != null) {
	            String otp = userService.generateOTP(customer);
	            // Use a messaging service to send OTP via SMS (e.g., Twilio)
	            return ResponseEntity.ok("OTP generated and sent successfully!");
	        } else {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Phone number not found!");
	        }
	    }

	    @PostMapping("/verify-otp")
	    public ResponseEntity<String> verifyOTP(@RequestBody OtpVerificationRequest request) {
	        if (userService.verifyOTP(request.getPhoneNumber(), request.getOtp())) {
	            return ResponseEntity.ok("OTP verified successfully!");
	        } else {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect OTP!");
	        }
	    }
	}