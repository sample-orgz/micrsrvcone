package com.ynap.operations.configurations;

import java.io.IOException;

import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.cluster.settings.ClusterGetSettingsRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
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
		
		System.out.println("HOSTNAME:: "+hostName);
		/*
		ClientConfiguration clientConfiguration = ClientConfiguration
			      										.builder()
												        .connectedTo(hostName+":"+port)
												        .build();

		return RestClients.create(clientConfiguration).rest();*/
		
		RestHighLevelClient client = new RestHighLevelClient(
		        RestClient.builder(new HttpHost(hostName, 9200, "http")));
		
		ClusterGetSettingsRequest request = new ClusterGetSettingsRequest();
		request.includeDefaults(true);
		
		try {
			System.out.println(client.cluster().getSettings(request, RequestOptions.DEFAULT));
		} catch (IOException e) {
			// TODO Auto-generated catch block	
			e.printStackTrace();
		}
		return client;
	}
	/*
	@Bean
	public ElasticsearchOperations elasticsearchTemplate() {
        return new ElasticsearchRestTemplate(elasticsearchClient());
    }*/
	
}
