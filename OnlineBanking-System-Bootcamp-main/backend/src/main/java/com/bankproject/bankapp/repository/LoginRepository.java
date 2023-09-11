package com.bankproject.bankapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankproject.bankapp.entity.Login;



@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {

	public Login findByUserId(long userId) ;
}