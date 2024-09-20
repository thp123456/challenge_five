package com.challengethree.Swagger.Response;

import lombok.*;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SuccessRespo {
	private String message;
	private Object responseData;
	private boolean success;
	private int status;
	private Object violations;
	private String path;
	private long timestamp;
}
