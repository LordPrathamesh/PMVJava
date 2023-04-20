package com.example.pvm.utils;

import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pvm.model.MstOtp;
import com.example.pvm.repo.MstOtpRepo;

@Service
public class Utils {

	@Autowired
	private MstOtpRepo otpRepo;

	public int generateOTP() {
		Random random = new Random();
		MstOtp mstOtp = new MstOtp();
		Integer otp = random.nextInt(9999 - 1000 + 1) + 1000;
		mstOtp.setActive(true);
		mstOtp.setCreatedDate(LocalDateTime.now());
		mstOtp.setOtpValue(otp.toString());
		otpRepo.save(mstOtp);
		return otp;
	}

}
