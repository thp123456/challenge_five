package com.challengethree.Swagger.Response;

import java.util.Map;

public class SuccessRespo {
	private String message;
	private Map<String, Object> responseData;
	private boolean success;
	private int status;
	private Object violations;
	private String path;
	private long timestamp;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String, Object> getResponseData() {
		return responseData;
	}

	public void setResponseData(Map<String, Object> responseData) {
		this.responseData = responseData;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Object getViolations() {
		return violations;
	}

	public void setViolations(Object violations) {
		this.violations = violations;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public SuccessRespo() {

	}

	public SuccessRespo(String message, Map<String, Object> responseData, boolean success, int status,
			Object violations, String path, long timestamp) {
		super();
		this.message = message;
		this.responseData = responseData;
		this.success = success;
		this.status = status;
		this.violations = violations;
		this.path = path;
		this.timestamp = timestamp;
	}
}
