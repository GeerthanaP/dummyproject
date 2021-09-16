package com.facebookboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.facebookboot.entity.FacebookEmployee;
import com.facebookboot.service.FacebookServiceInterface;

@RestController
public class FacebookController {
	
	@Autowired
	private FacebookServiceInterface fs;
	
	@GetMapping("empList")
	public List<FacebookEmployee> viewaLL(){
		List<FacebookEmployee> ll=new ArrayList<FacebookEmployee>();
		
		FacebookEmployee fe1=new FacebookEmployee();
		fe1.setName("sanghvi");
		fe1.setId(11);
		fe1.setPassword("abcd");
		fe1.setEmail("abc@yahoo.com");
		fe1.setAddress("Bangalore");
		
		FacebookEmployee fe2=new FacebookEmployee();
		fe2.setName("sanghvi2");
		fe2.setId(112);
		fe2.setPassword("abcd2");
		fe2.setEmail("abc@yahoo.com2");
		fe2.setAddress("Bangalore2");
		
		ll.add(fe1);
		ll.add(fe2);
		
		return ll;
	}
	
	@GetMapping("emp/{email}")
	public String view(@PathVariable("email") String usermail){
		return usermail+"  found" ;
	}
	
	@PostMapping("registerEmp")
	public String createProfile(@RequestBody FacebookEmployee fe){
		int i=fs.createProfileService(fe);
		String ss="could not create profile";
		if(i>0) {
			ss="profile created "+fe.getName();
		}
		return ss;
	}
	
	@PutMapping("editEmp")
	public String updateProfile(){
		return "profile updated";
	}
	
	@DeleteMapping("deleteEmp/{username}")
	public String deleteProfile(@PathVariable("username") String nn){
		int i=fs.deleteProfile(nn);
		String ss="could not delete profile";
		if(i>0) {
			ss="profile deleted for "+nn;
		}
		return ss;
	}
}





















