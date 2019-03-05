package com.example.demo.controllers;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.beans.User;
import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.service.UserCrudService;

import net.bytebuddy.implementation.bytecode.Throw;

@RestController
public class UserRestController{
	//final String Path="/error"; 
	@Autowired
	UserCrudService dto;
	@GetMapping("/welcome1")
	//@RequestMapping(method=RequestMethod.GET,value="/welcome1", produces = MediaType.APPLICATION_XML_VALUE)
	public HashMap<String, String> welcomeMethod1() 
	{
		HashMap<String, String> hmap=new HashMap<String, String>();
		hmap.put("a1", "abc");
		hmap.put("a2", "xyz");
		return hmap;
	}

	@GetMapping(path="/welcome2/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	//@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public String welcomeMethod2(@PathVariable String id) 
	{
		System.out.println("id is : "+id);
		return "{\"a1\": \""+id+"\"}";
	}
	
	@RequestMapping(value="/user",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> addUser(@RequestBody @Valid User u)
	{
		System.out.println(u);
		int id=dto.saveUser(u);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").build().expand(id).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@RequestMapping(value="/user",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<User> getUsers()
	{
		return dto.getUsers();
	}
	
	@RequestMapping(value="/user/{id}",method=RequestMethod.GET)
	public ResponseEntity<Object> getUser(@PathVariable() int id)
	{
		Optional<User> opUser=dto.getUserById(id);
		if(opUser.isPresent())
		{
			User u=opUser.get();
			return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(u);
		}
		else
		{
			throw new UserNotFoundException(id);
			//return ResponseEntity.ok().contentType(MediaType.TEXT_PLAIN).body("User with id : "+id+"not found");
		}
	}
	
	@RequestMapping(path="user/{id}",produces={MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<Object> deleteUserById(@PathVariable("id") int id)
	{
		User u=dto.getUserById(id).orElseThrow(()-> new UserNotFoundException(id));
		dto.deleteUserById(id);
		return ResponseEntity.ok().body("User Deleted : {"+u.toString()+"}");
	}
}
