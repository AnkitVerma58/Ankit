package com.pratikshat.api.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pratikshat.api.entity.EngDetails;
@Repository
public interface EngDetailRepository extends JpaRepository<EngDetails, Integer>{

	
	
	
	public EngDetails findByEngid(int id);
	
	public EngDetails findByEngname(String name);
	
	
	public List<EngDetails> findByDate( String date);
	
	
	public EngDetails findByEngidAndDate( int id, String date);
	
}