package com.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**gestaoFesta
 * GestaoFesta.java
 * @author jaime
 * Em 10-05-2020 **/


@SpringBootApplication
@ComponentScan({"com.controller","com.model","com.repository","com.security"})
@EntityScan("com")
@EnableJpaRepositories("com.repository")
@EnableAutoConfiguration
public class GestaoFesta {

	public static void main(String[] args) {
		SpringApplication.run(GestaoFesta.class, args);

	}

}
