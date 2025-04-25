package com.yogeshdofficial.catalogue;

import org.springframework.boot.SpringApplication;

public class TestCatalogueServiceApplication {

	public static void main(String[] args) {
		SpringApplication.from(CatalogueApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
