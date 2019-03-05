package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.beans.User;
import com.example.demo.respository.UserCrudRepository;

@Service
public class UserCrudService {

	@Autowired
	UserCrudRepository dao;

	public int saveUser(User u) {
		u.setId(Integer.parseInt((Long.toString(dao.count())))+1);
		System.out.println(u);
		dao.save(u);
		return u.getId();
	}

	public List<User> getUsers() {
		
		return dao.findAll();
	}
	
	public Optional<User> getUserById(int id)
	{
		return dao.findById(id);
	}
	
	public void deleteUserById(int id)
	{
		dao.deleteById(id);
	}

	
}
