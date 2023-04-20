package com.example.pvm.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pvm.model.MstUser;

public interface MstUserRepo extends JpaRepository<MstUser, Long>{

}
