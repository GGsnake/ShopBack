package io.sbed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableAsync;

//@SpringBootApplication
//@EnableAsync
//public class SbedApplication extends SpringBootServletInitializer {
//
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        // 注意这里一定要指向原先用main方法执行的Application启动类
//        return builder.sources(SbedApplication.class);
//    }
//    public static void main(String[] args) {
//        SpringApplication.run(SbedApplication.class, args);
//    }
//}


//@EnableEurekaClient
//@EnableFeignClients
@SpringBootApplication
@EnableAsync
public class SbedApplication {
    public static void main(String[] args) {
        SpringApplication.run(SbedApplication.class, args);
    }

}
