package com.example.demo.exceptions;

import java.util.Date;

public class ExceptionResponse {

	private Date timestamp;
	private String detail;
	private String request;

	public ExceptionResponse() {

	}

	public ExceptionResponse(Date timestamp, String detail, String request) {
		super();
		this.timestamp = timestamp;
		this.detail = detail;
		this.request = request;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	@Override
	public String toString() {
		return "ExceptionResponse [timestamp=" + timestamp + ", detail=" + detail + ", request=" + request + "]";
	}

}
