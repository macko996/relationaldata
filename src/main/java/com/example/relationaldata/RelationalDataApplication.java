package com.example.relationaldata;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class RelationalDataApplication implements CommandLineRunner {

	private static final Logger log= LoggerFactory.getLogger(RelationalDataApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RelationalDataApplication.class, args);
	}

	@Autowired
	JdbcTemplate jdbcTemplate;

	public void run(String ... string) throws Exception {
		log.info("Creating tables");

		jdbcTemplate.execute("DROP TABLE customers IF EXISTS");
		jdbcTemplate.execute("CREATE TABLE customers(id SERIAL , first_name VARCHAR(255) , last_name VARCHAR(255) )");
	}
}
