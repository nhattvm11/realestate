package com.project.realestate;

import com.project.realestate.helper.PayPalHelper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@ComponentScan(basePackages = {"com.project.realestate"})
public class RealestateApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(RealestateApplication.class, args);
		PayPalHelper payPalHelper = new PayPalHelper();
		payPalHelper.test();
	}


	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(RealestateApplication.class);
	}



}
