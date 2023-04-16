package com.example.project.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.project.Model.ApplicationUser;
import com.example.project.repository.ApplicationUserRepository;

@Service
public class UserAuthService implements UserDetailsService {

	private ApplicationUserRepository repo;

	@Autowired
	public UserAuthService(ApplicationUserRepository repo) {
		this.repo = repo;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<ApplicationUser> user = repo.findById(username);
		return new User(user.get().user_name, user.get().password, new ArrayList<>());
	}

}