package com.example.pvm.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mst_user")
public class MstUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private UUID userUUid;
	private String email;
	private String username;
	private boolean isActive;

	public MstUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int userId) {
		this.id = userId;
	}

	public UUID getUserUUid() {
		return userUUid;
	}

	public void setUserUUid(UUID userUUid) {
		this.userUUid = userUUid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "MstUser [userId=" + id + ", userUUid=" + userUUid + ", email=" + email + ", username=" + username
				+ ", isActive=" + isActive + "]";
	}

}
