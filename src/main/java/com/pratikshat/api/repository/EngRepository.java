package com.pratikshat.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.pratikshat.api.entity.EngData;
import com.pratikshat.api.entity.LoginData;

@Repository
public interface EngRepository extends JpaRepository<EngData, Integer> {
	
	
//	@Query("SELECT name,date,profile,assigned_task,reported_to  FROM EngData   ")
//	public List<EngData> findByEngdata();

}
