package com.tasks.services;

import java.util.List;

import com.tasks.pojos.User;

public interface UserService {
	
	public List<User> getAllOrderedDescendingByMail();

}
