package com.facebookboot.service;

import com.facebookboot.entity.FacebookEmployee;

public interface FacebookServiceInterface {

	int createProfileService(FacebookEmployee fe);
	int deleteProfile(String name);

}
