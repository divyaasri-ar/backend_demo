package com.example.demo.service;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class TwilioService {

    // Twilio credentials from your Twilio account
    private final String ACCOUNT_SID = "AC73eda65991716f864fc3e1f488cd6368";
    private final String AUTH_TOKEN = "5db091099d63338fee5cbe723cfa4b77";
    private final String TWILIO_PHONE_NUMBER = "+12569063492";

    public TwilioService() {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    }

    public void sendOtp(String phoneNumber, String otp) {
        String messageBody = "Your OTP is: " + otp;

        // Send the SMS via Twilio
        Message message = Message.creator(
                new PhoneNumber(phoneNumber),  // To phone number
                new PhoneNumber(TWILIO_PHONE_NUMBER),  // From Twilio phone number
                messageBody)
            .create();

        System.out.println("OTP sent successfully. SID: " + message.getSid());
    }
}


