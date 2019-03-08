package io.sbed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

//@SpringBootApplication
////@EnableEurekaClient
////@EnableFeignClients
//public class SbedApplication extends SpringBootServletInitializer {
//	public static void main(String[] args) {
//		SpringApplication.run(SbedApplication.class, args);
//	}
//
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//		return application.sources(SbedApplication.class);
//	}
//}

@SpringBootApplication
//@EnableEurekaClient
//@EnableFeignClients
public class SbedApplication  {
	public static void main(String[] args) {
		SpringApplication.run(SbedApplication.class, args);
	}

}
