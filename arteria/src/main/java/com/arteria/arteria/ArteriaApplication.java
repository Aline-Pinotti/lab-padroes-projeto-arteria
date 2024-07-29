package com.arteria.arteria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Projeto Spring Boot gerado via Spring Initializr.
 * Os seguintes módulos foram selecionados:
 * - Spring Data JP
 * - Spring Web
 * - H2 Database
 * - OpenFeign
 * 
 * @author Aline-Pinotti
 * 
 */

@EnableFeignClients
@SpringBootApplication
public class ArteriaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArteriaApplication.class, args);
	}

}
