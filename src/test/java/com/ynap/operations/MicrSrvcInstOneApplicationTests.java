package com.ynap.operations;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
class MicrSrvcInstOneApplicationTests {

	/*@Test
	void contextLoads() {
	}*/
	@Test
	public void test() {
		System.out.println("run test cases");
	}
	
	@Test
	public void loadTest() {
		System.out.println("run test cases-2");
	}
	
}
