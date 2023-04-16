package com.example.pvm.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.pvm.service.EmailSender;

@RestController
@RequestMapping("/api")
public class RegistrationController {

	@Autowired
	private EmailSender emailSender;

	@SuppressWarnings("unchecked")
	@GetMapping("send-email")
	public ResponseEntity<Object> testEmail(@RequestParam() String recipients) {
		System.out.println("recipients==>" + recipients);
		Map<String, String> resp = emailSender.sendEmail(recipients);
		return new ResponseEntity<Object>(resp, HttpStatus.OK);
	}

}
