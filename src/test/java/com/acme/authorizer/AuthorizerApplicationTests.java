package com.acme.authorizer;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.modulith.core.ApplicationModules;

@SpringBootTest
class AuthorizerApplicationTests {

	@Test
	void contextLoads() {
		var modules = ApplicationModules.of(AuthorizerApplication.class);
		modules.forEach(System.out::println);
		//ApplicationModules.of(AuthorizerApplication.class).verify();
	}

}
