package com.ynap.operations.configurations;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.ynap.operations.repository")
public class ElasticSearchConfig extends AbstractElasticsearchConfiguration{
	
	@Value("${elasticsearch.host.name}")
	private String hostName;
	
	@Value("${elasticsearch.port}")
	private String port;

	@Override
	@Bean
	public RestHighLevelClient elasticsearchClient() {
		
		ClientConfiguration clientConfiguration = ClientConfiguration
			      										.builder()
												        .connectedTo(hostName+":"+port)
												        .build();

		return RestClients.create(clientConfiguration).rest();
	}
	/*
	@Bean
    public ElasticsearchOperations elasticsearchTemplate() {
        return new ElasticsearchRestTemplate(elasticsearchClient());
    }
	*/
}
