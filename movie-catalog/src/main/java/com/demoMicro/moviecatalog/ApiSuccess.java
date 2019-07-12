package com.demoMicro.moviecatalog;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;



public class ApiSuccess {

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp;
	private HttpStatus status;
	private Object data;

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	private ApiSuccess() {
		timestamp = LocalDateTime.now();
	}

	public ApiSuccess(HttpStatus status) {
		this();
		this.status = status;
	}

	public ApiSuccess(HttpStatus status, Object object) {
		this();
		this.status = status;
		this.data = object;
	}

}
