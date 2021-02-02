package com.pratikshat.api.service;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.pratikshat.api.entity.EngData;
import com.pratikshat.api.entity.EngDetails;
import com.pratikshat.api.entity.LoginData;
import com.pratikshat.api.entity.RoleClass;
import com.pratikshat.api.repository.EngDetailRepository;
import com.pratikshat.api.repository.EngRepository;
import com.pratikshat.api.repository.LogRepository;

@Service
public class EngService {

	@Autowired
	private LogRepository logRepository;
	
	@Autowired
	private EngDetailRepository engDetailRepository;
	
	@Autowired
	private EngRepository engRepository;
	
	public ResponseEntity<?> loginData(LoginData loginData)
	{
		if(loginData!=null)
		{
			LoginData login2=logRepository.findByEngidAndRole(loginData.getEngid(),loginData.getPassword());
			if(login2!=null)
			{
				
				RoleClass roleClass=new RoleClass();
				roleClass.setEngid(login2.getEngid());
				roleClass.setEngname(login2.getName());
				roleClass.setRole(login2.getRole());
				String role=login2.getRole();
			
			return ResponseEntity.ok(roleClass);
		}else
		{
			return ResponseEntity.badRequest().body("null");
		}
		}else
		{
			return ResponseEntity.badRequest().body("your data not found");	
		}
			
	}
	
	public String saveEngDetails(EngDetails engDetails)
	{
		EngDetails engDetails2=engDetailRepository.findByEngname( engDetails.getEngname());
		if(engDetails2!=null)
		{return "{data already inserted}";}
		else
		{
	EngData engData=new EngData();
	
	engData.setEngid(engDetails.getEngid());
	engData.setName(engDetails.getEngname());
	engData.setProfile(engDetails.getProfile());
	engData.setDate(engDetails.getDate());
	engData.setAssigned_task(engDetails.getAssigned_task());
	engData.setReported_to(engDetails.getReported_to());
	
	engRepository.save(engData);
	System.out.println(engData.getEngid());
		
	engDetailRepository.save(engDetails);
		System.out.println(engDetails.getEngid());
		
		return "{data inserted}";
		}
	}
	
	public  EngDetails getEngid(EngDetails engDetails )
	{
		
			EngDetails engDetails2=engDetailRepository.findByEngid(engDetails.getEngid());
			return engDetails2;
		
	}
	public List<EngDetails>  getEngDate(EngDetails engDetails ) throws ParseException
	{
		

		List<EngDetails> engDetails2=engDetailRepository.findByDate(engDetails.getDate());
	
		return engDetails2;
		
	}	
	
	public EngDetails getEngIdAndDate(EngDetails engDetails)
	{
		EngDetails engDetails2=engDetailRepository.findByEngidAndDate(engDetails.getEngid(), engDetails.getDate());
		return engDetails2;
	}
	
	
	public List<EngDetails> getAllEngDetails()
	{
		List<EngDetails> list=engDetailRepository.findAll();
		return list;
	}
	
	
	public List<EngData> getEngData()
	{
		List<EngData> list=engRepository.findAll();
		return list;
	}
	
	
	public String update(EngDetails engDetails)
	{ 
		 EngDetails _eng=engDetailRepository.findByEngid(engDetails.getEngid());
        _eng.setStatus(engDetails.getStatus());
		_eng.setRemark(engDetails.getRemark());
		_eng.setUpdateDate(new java.util.Date());
		engDetailRepository.save(_eng);
    	
		return "{insert data successfull}";
	}
	
	public RoleClass saveEngData(EngData engData)
	{
		RoleClass role=new RoleClass();
		engRepository.save(engData);
		role.setResponse("save successfully");
		return role;
	}
	
	
}
