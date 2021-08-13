package org.study.employee.down;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EmployeeDownApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeDownApplication.class, args);
	}

}
