package com.example.demo.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

public class ErrorResponse {
	private HttpStatusCode code;
	private HttpStatus httpStatus;
	private String errMsg;
	private LocalDateTime dateTime;
	public HttpStatusCode getCode() {
		return code;
	}
	public void setCode(HttpStatusCode code) {
		this.code = code;
	}
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	public String getErrMsg() {
		return errMsg;
	}
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	public ErrorResponse(HttpStatusCode code, HttpStatus httpStatus, String errMsg, LocalDateTime dateTime) {
		super();
		this.code = code;
		this.httpStatus = httpStatus;
		this.errMsg = errMsg;
		this.dateTime = dateTime;
	}
	public ErrorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
