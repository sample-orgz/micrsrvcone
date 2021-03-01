package com.ynap.operations.repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(indexName = "#{@environment.getProperty('elasticsearch.index.prefix')}_uppl", createIndex = false)
public class UPPLVariantDetails {

	@Id
	@Field(name= "id")
	private String id;
	
	@Field(name= "variantId")
	private Long variantId;
	
	@Field(name= "modelFabricColour")
	private String modelFabricColour;
	
	@Field(name= "saleSeason")
	private String saleSeason;
	
	@Field(name= "brandColour")
	private String brandColour;
	
	@Field(name= "brandColourCode")
	private String brandColourCode;
	
	@Field(name= "productClassification")
	private String productClassification;
	
	@Field(name= "productType")
	private String productType;
	
	@Field(name= "productSubType")
	private String productSubType;
	
	@Field(name= "channel")
	private String channel;
	
	@Field(name= "department")
	private String department;
	
	@Field(name= "modelId")
	private String modelId;
	
	@Field(name= "modelFabric")
	private String modelFabric;
	
	@Field(name= "productName")
	private String productName;
	
	@Field(name= "saleLine")
	private String saleLine;
	
	@Field(name= "gender")
	private String gender;
	
	@Field(name= "editorialDescription")
	private String editorialDescription;
	
	@Field(name= "shortDescription")
	private String shortDescription;
	
	@Field(name= "brand")
	private BrandModel brand;
	
	@Field(name= "catalog")
	private CatalogModel catalog;
	
	@Field(name= "items")
	private ItemModel items;
}
