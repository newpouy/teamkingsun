package team.dkh.pj;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.context.ConfigurableWebApplicationContext;
import org.springframework.web.context.ContextLoader;

import myCypher.MyAES256Cipher;

@Configuration
public class MyAppContext {
	
	private DriverManagerDataSource dmds;
	
	@Bean
	public DriverManagerDataSource setDriverManagerDataSource(){
		System.out.println("ddd");
		dmds = new DriverManagerDataSource();
		dmds.setDriverClassName("com.mysql.jdbc.Driver");
		dmds.setUrl("jdbc:mysql://127.0.0.1:3306/test");
		dmds.setUsername("root");
		dmds.setPassword("cv4069cv");
		System.out.println("dddd: "+dmds.getUrl());
		return dmds;
	};
	
}
