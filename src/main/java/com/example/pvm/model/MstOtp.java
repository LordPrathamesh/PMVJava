package com.example.pvm.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mst_otp")
public class MstOtp {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String otpValue;
	
	private boolean isActive;
	
	private LocalDateTime createdDate;

	public MstOtp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOtpValue() {
		return otpValue;
	}

	public void setOtpValue(String optValue) {
		this.otpValue = optValue;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "MstOtp [id=" + id + ", optValue=" + otpValue + ", isActive=" + isActive + ", createdDate=" + createdDate
				+ "]";
	}
	
	

}
