package com.challengethree.Swagger.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class ErrorRespo {
	private String message;
	private Object responseData;
	private boolean success;
	private int status;
	private Map<String, String> violations;
	private String path;
	private long timestamp;

	public ErrorRespo(String message, boolean success, int status, Map<String, String> violations, String path, long timestamp) {
		this.message = message;
		this.success = success;
		this.status = status;
		this.violations = violations;
		this.path = path;
		this.timestamp = timestamp;
	}

	public ErrorRespo() {

	}

//	public String getMessage() {
//		return message;
//	}
//
//	public void setMessage(String message) {
//		this.message = message;
//	}
//
//	public Object getResponseData() {
//		return responseData;
//	}
//
//	public void setResponseData(Object responseData) {
//		this.responseData = responseData;
//	}
//
//	public boolean isSuccess() {
//		return success;
//	}
//
//	public void setSuccess(boolean success) {
//		this.success = success;
//	}
//
//	public int getStatus() {
//		return status;
//	}
//
//	public void setStatus(int status) {
//		this.status = status;
//	}
//
//	public Map<String, String> getViolations() {
//		return violations;
//	}
//
//	public void setViolations(Map<String, String> violations) {
//		this.violations = violations;
//	}
//
//	public String getPath() {
//		return path;
//	}
//
//	public void setPath(String path) {
//		this.path = path;
//	}
//
//	public long getTimestamp() {
//		return timestamp;
//	}
//
//	public void setTimestamp(long timestamp) {
//		this.timestamp = timestamp;
//	}
//
//	public ErrorRespo() {
//
//	}
//
//	public ErrorRespo(String message, Object responseData, boolean success, int status, Map<String, String> violations,
//			String path, long timestamp) {
//		super();
//		this.message = message;
//		this.responseData = responseData;
//		this.success = success;
//		this.status = status;
//		this.violations = violations;
//		this.path = path;
//		this.timestamp = timestamp;
//	}
}
