package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
	private final int id;
	private final String msg;

	public UserNotFoundException(int id) {
		this.id = id;
		this.msg = "No user can not be find with the id : " + id;
	}

	public int getId() {
		return id;
	}

	public String getMsg() {
		return msg;
	}

	@Override
	public String toString() {
		return "UserNotFoundException [msg=" + msg + "]";
	}

}
