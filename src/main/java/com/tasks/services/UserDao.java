package com.tasks.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tasks.pojos.User;
import com.tasks.repos.UserRepository;

public class UserDao implements UserService {
	@Autowired
	private UserRepository urepo;

	@Override
	public List<User> getAllOrderedDescendingByMail() {
		
		
		return urepo.findAllOrderedDescendingByMail();
	}

}
