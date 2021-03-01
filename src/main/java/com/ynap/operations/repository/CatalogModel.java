package com.ynap.operations.repository;

import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CatalogModel {
	
	@Field(name = "catalogIdentifier")
	private String catalogIdentifier;
	
	@Field(name = "liveStatus")
	private String liveStatus;
}
