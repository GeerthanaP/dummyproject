package com.facebookboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.facebookboot.dao.FacebookDAOInterface;
import com.facebookboot.entity.FacebookEmployee;
@Service
@Transactional
public class FacebookService implements FacebookServiceInterface {

	@Autowired
	private FacebookDAOInterface fd;
	
	@Override
	public int createProfileService(FacebookEmployee fe) {
		int i=0;
		fd.save(fe);
		i=1;
		return i;
	}

	@Override
	public int deleteProfile(String name) {
		// TODO Auto-generated method stub
		return fd.deleteByUsername(name);
	}

}
