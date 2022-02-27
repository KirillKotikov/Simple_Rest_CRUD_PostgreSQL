package com.example.demo.config;

import com.example.demo.DemoApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.*;

import javax.sql.DataSource;

public class  ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DemoApplication.class);
	}


	public DataSource dataSource() {
		 DriverManagerDataSource dataSource = new DriverManagerDataSource();

		 dataSource.setDriverClassName("org.postgresql.Driver");
		 dataSource.setUrl("jdbc.postgresql://localhost:5432/first_db");
		 dataSource.setPassword("postgres");
		 dataSource.setUsername("postgres");

		 return dataSource;
	}

	@Bean
	public JdbcTemplate jdbcTemplate(){
		return new JdbcTemplate(dataSource());
	}
}
