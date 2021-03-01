package com.ynap.operations.controller;

import java.util.ArrayList;
import java.util.List;

import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ynap.operations.repository.UPPLVariantDetails;

@RequestMapping("uppl/data")
@RestController
public class ESController {
	
	@Value("${elasticsearch.index.prefix}")
	private String indexPrefix;
	
	@Autowired
	private ElasticsearchOperations elasticsearchOperations;
	
	@GetMapping(path = "/brandName/{brandName}")
	public ResponseEntity<String> findData(@PathVariable String brandName) {
		
		String indexName = indexPrefix+"_uppl";
		List<String> brandCodes = new ArrayList<String>();
		
		QueryBuilder queryBuilder = QueryBuilders.matchQuery("brand.name",brandName);
		
		Query searchQuery = new NativeSearchQueryBuilder()
			      				.withQuery(queryBuilder)
			      				.build();
		SearchHits<UPPLVariantDetails> variants = elasticsearchOperations.search(searchQuery, 
			    		  							UPPLVariantDetails.class, IndexCoordinates.of(indexName));
		
		variants.forEach(variant -> brandCodes.add(variant.getContent().getBrand().getBrandCode()));
		
		brandCodes.forEach(brandCode -> System.out.println("BRAND CODE::"+brandCode));
		
		if(brandCodes.size()>0)
			return new ResponseEntity<String>(brandCodes.toString(), HttpStatus.OK);
		else
			return new ResponseEntity<String>("NO BRAND CODE FOUND", HttpStatus.OK);
		
	}
}
