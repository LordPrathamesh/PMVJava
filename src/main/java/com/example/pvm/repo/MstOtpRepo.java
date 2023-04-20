package com.example.pvm.repo;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.pvm.model.MstOtp;

public interface MstOtpRepo extends JpaRepository<MstOtp, Long> {

	@Query(value = "select * from mst_otp mo where mo.otp_value=:otpValue and is_active=true", nativeQuery = true)
	public List<Map<String, Object>> getOtpbyValue(String otpValue);

	@Transactional
	@Modifying
	@Query(value = "update mst_otp set is_active=false where id=:id", nativeQuery = true)
	public int updateActiveStatus(long id);

}
