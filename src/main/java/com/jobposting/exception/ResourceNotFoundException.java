package com.jobposting.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
@NoArgsConstructor

public class ResourceNotFoundException extends RuntimeException {

	String resourceName;
	String fileName;
	long fieldValue;

	public ResourceNotFoundException(String resourceName, String fileName, long fieldValue) {
		super(String.format("Exception", resourceName, fileName, fieldValue));
		this.resourceName = resourceName;
		this.fileName = fileName;
		this.fieldValue = fieldValue;
	}

}
