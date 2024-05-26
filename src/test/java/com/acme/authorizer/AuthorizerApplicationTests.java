package com.acme.authorizer;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;
import org.springframework.modulith.test.ApplicationModuleTest;

@ApplicationModuleTest
class AuthorizerApplicationTests {

	@Test
	void moduleContextVerify() {
		var modules = ApplicationModules.of(AuthorizerApplication.class);
		modules.forEach(System.out::println);
		ApplicationModules.of(AuthorizerApplication.class).verify();
	}

	@Test
	void writeDocumentationSnippets() {
		var modules = ApplicationModules.of(AuthorizerApplication.class);
		new Documenter(modules)
				.writeModuleCanvases()
				.writeModulesAsPlantUml()
				.writeIndividualModulesAsPlantUml();
	}

}
