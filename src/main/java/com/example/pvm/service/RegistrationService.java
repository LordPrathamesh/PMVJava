package com.example.pvm.service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pvm.model.MstUser;
import com.example.pvm.repo.MstOtpRepo;
import com.example.pvm.repo.MstUserRepo;

@Service
public class RegistrationService {

	@Autowired
	private MstOtpRepo otpRepo;

	@Autowired
	private MstUserRepo userRepo;

	public Object verifyUser(Map<String, Object> payload) {
		MstUser mstUser = new MstUser();
		mstUser.setActive(true);
		mstUser.setEmail(payload.get("email").toString());
		String username = payload.get("email").toString().split("@")[0];
		mstUser.setUsername(username);
		mstUser.setUserUUid(UUID.randomUUID());
		List<Map<String, Object>> lstResp = otpRepo.getOtpbyValue(payload.get("otp").toString());
		if (lstResp.size() > 0) {
			System.out.println("===Found===");
			int count = otpRepo.updateActiveStatus(Long.parseLong(lstResp.get(0).get("id").toString()));
			if (count > 0) {
				userRepo.save(mstUser);
			}

//			sys
		} else {
			System.out.println("===Absent===");
		}

		return lstResp;

	}

}
