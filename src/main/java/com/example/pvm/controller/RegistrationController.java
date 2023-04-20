package com.example.pvm.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.pvm.service.EmailSender;
import com.example.pvm.service.RegistrationService;

@RestController
@RequestMapping("/api")
public class RegistrationController {

	@Autowired
	private EmailSender emailSender;

	@Autowired
	private RegistrationService registrationService;

	@SuppressWarnings("unchecked")
	@GetMapping("send-email")
	public ResponseEntity<Object> testEmail(@RequestParam() String recipients) {
		System.out.println("recipients==>" + recipients);
		Map<String, String> resp = emailSender.sendEmail(recipients);
		return new ResponseEntity<Object>(resp, HttpStatus.OK);
	}

	@GetMapping("test")
	public ResponseEntity<Object> test() {

		return new ResponseEntity<Object>("Test", HttpStatus.OK);
	}

	@PostMapping("verify-user")
	public ResponseEntity<Object> verifyUser(@RequestBody Map<String, Object> paylaod) {

		return new ResponseEntity<Object>(registrationService.verifyUser(paylaod), HttpStatus.OK);
	}

}
