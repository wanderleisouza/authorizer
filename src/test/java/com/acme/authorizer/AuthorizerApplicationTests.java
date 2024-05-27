package com.acme.authorizer;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

class AuthorizerApplicationTests {

	ApplicationModules modules = ApplicationModules.of(AuthorizerApplication.class);

	@Test
	void moduleContextVerify() {
		modules.forEach(System.out::println);
		modules.verify();
	}

	@Test
	void writeDocumentationSnippets() {
		new Documenter(modules)
				.writeModuleCanvases()
				.writeModulesAsPlantUml()
				.writeIndividualModulesAsPlantUml();
	}

}
