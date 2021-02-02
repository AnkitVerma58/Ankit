package com.pratikshat.api.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pratikshat.api.entity.EngData;
import com.pratikshat.api.entity.EngDetails;
import com.pratikshat.api.entity.LoginData;
import com.pratikshat.api.entity.RoleClass;
import com.pratikshat.api.service.EngService;

@RestController
@CrossOrigin
public class EngController {

	@Autowired
	private EngService engService; 
	
	 @RequestMapping(value = "/datalogin", method = RequestMethod.POST)
	public ResponseEntity<?> roleLogin(@RequestBody LoginData loginData) 
	 {
	
		ResponseEntity login2=engService.loginData(loginData);
		 return ResponseEntity.ok(login2);
		 
	 }
	 
	 @RequestMapping(value = "/savedetails", method = RequestMethod.POST)
	 public ResponseEntity<?> saveEngDetails(@RequestBody EngDetails engDetails )
	 {
		 
		
		 String str=engService.saveEngDetails(engDetails); 
		 RoleClass role=new RoleClass();
		 role.setResponse(str);
		 return ResponseEntity.ok(role);
	 }
	 
	 @RequestMapping(value = "/getdetails", method = RequestMethod.POST)
	 public ResponseEntity<?> getAllEngDetails(@RequestBody EngDetails engDetails) throws ParseException
	 {
		 
		 if(engDetails.getEngid()==0   && engDetails.getDate().toString().equalsIgnoreCase("")) 
			{
			
			 List<EngDetails> list=engService.getAllEngDetails();
			
					return ResponseEntity.ok(list);
			}
			else if( engDetails.getEngid()!=0  && engDetails.getDate().toString().equalsIgnoreCase(""))
			{ 
				EngDetails engDetails2=engService.getEngid(engDetails);
				
				return ResponseEntity.ok(engDetails2);
			}
			 if(engDetails.getEngid()==0  && engDetails.getDate()!=null)
			{
				
				 List<EngDetails> engDetails2=engService.getEngDate(engDetails);
			 
			
			return ResponseEntity.ok(engDetails2);
			}
			else
			{
				EngDetails engDetails2=engService.getEngIdAndDate(engDetails);	
				return ResponseEntity.ok(engDetails2);
			}
			 }
			
		
	 
	 @RequestMapping(value = "/update", method = RequestMethod.POST)
	    public  ResponseEntity<?> updateUserData(@RequestBody EngDetails engDetails) {
		 String str=null;
		 try{
	          str=engService.update(engDetails);
	         }
	        catch(Exception e){e.printStackTrace();}
		 RoleClass role=new RoleClass();
		 role.setResponse(str);
		 	return ResponseEntity.ok(role);
	       
}
	 @RequestMapping(value = "/getengdata", method = RequestMethod.POST)
	 public  ResponseEntity<?> getEngData(@RequestBody RoleClass role)
	 {
		 
		 String role1=role.getRole();
		 if(role1.equals("admin"))
		 {
		 List<EngData> engDetail= engService.getEngData(); 
		 return ResponseEntity.ok(engDetail); 
	  }if(role1.equals("eng"))
	  {
		   
		  List<EngDetails> engDetails= engService.getAllEngDetails(); 
		  return ResponseEntity.ok(engDetails);
 
	  }
		 else
		 {
			 
			 return  ResponseEntity.badRequest().body("not correct role");
		 }
		 }
	 
//	 @RequestMapping(value = "/saveengdata", method = RequestMethod.POST)
//	 public RoleClass saveEngData(@RequestBody EngData engData)
//	 {
//		 RoleClass str=engService.saveEngData(engData);
//		 return str;
//	 }
	
}
