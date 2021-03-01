package com.ynap.operations.repository;

import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BrandModel {
	
	@Field(name = "code")
	private String brandCode;
	
	@Field(name = "name")
	private String brandName;

}
