package com.company.engineering.Web;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.WebApplicationInitializer;

@SpringBootApplication
@PropertySource("file:/data/csm/config.properties")
@ComponentScan(basePackages = "com.company.engineering")
public class WebApplication extends SpringBootServletInitializer implements WebApplicationInitializer{

	
	@Value("${oracle.jdbc.driver}")
	private String oracleDriver;
	@Value("${oracle.database}")
	private String oracleDatabase;
	@Value("${db.username}")
	private String dbUsername;
	@Value("${db.password}")
	private String dbPassword;

	@Value("${db.oracle.maxactive}")
	private Integer maxActive;

	@Value("${db.oracle.maxidle}")
	private Integer maxIdle;

	@Value("${db.oracle.minidle}")
	private Integer minIdle;

	@Value("${db.oracle.initialsize}")
	private Integer initialSize;
	
	
	@Value("${spring.data.mongodb.uri}")
	private String mongodbUri;
	
	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
		System.out.println("App running");
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(WebApplication.class);
	}

	@Bean
	public BasicDataSource dataSource() {

		final BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(oracleDriver);
		dataSource.setUrl(oracleDatabase);
		dataSource.setUsername(dbUsername);
		dataSource.setPassword(dbPassword);
		dataSource.setMaxActive(maxActive);
		dataSource.setMaxIdle(maxIdle);
		dataSource.setInitialSize(initialSize);
		dataSource.setMinIdle(minIdle);

		return dataSource;
	}
}
