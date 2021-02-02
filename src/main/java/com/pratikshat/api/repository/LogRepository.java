package com.pratikshat.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pratikshat.api.entity.EngDetails;
import com.pratikshat.api.entity.LoginData;

@Repository
public interface LogRepository extends JpaRepository<LoginData, Integer> {

	@Query("SELECT u FROM LoginData u WHERE u.engid = :engid AND u.password = :password ")
	public LoginData findByEngidAndRole(@Param("engid") int engid,@Param("password") String password);
	
	@Query("SELECT u FROM LoginData u WHERE u.engid = :engid AND u.name = :engname ")
	public LoginData findByEngidAndEngname(@Param("engid") int engid,@Param("engname") String engname);
	
}
