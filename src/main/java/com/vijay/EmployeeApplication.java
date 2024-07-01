package com.vijay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@SpringBootApplication
@OpenAPIDefinition(
		
		info = @Info(
				title = "Employee OPEN API",
				version = "1.0.0",
				description = "Employee OPEN API Documentation"
				), 
		
				servers = @Server(
						url = "http://localhost:9189",
						description = "Employee OPEN API url"
						)
		)
public class EmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
		
	} 

}
