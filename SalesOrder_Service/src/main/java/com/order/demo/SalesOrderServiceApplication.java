package com.order.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.order.demo.repository.SalesOrderRepository;

@SpringBootApplication
@EnableJpaAuditing
@EnableJpaRepositories(basePackageClasses = SalesOrderRepository.class)
public class SalesOrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalesOrderServiceApplication.class, args);
	}
}
