package com.example.demo;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
@SpringBootApplication
public class Example {

	@RequestMapping("/")
	String home() {
		return "Hello World! Nice Spring Boot";
	}
	
    private static Log logger = LogFactory.getLog(Example.class);

    @Bean
    protected ServletContextListener listener() {
        return new ServletContextListener() {

            @Override
            public void contextInitialized(ServletContextEvent sce) {
                logger.info("ServletContext initialized");
            }

            @Override
            public void contextDestroyed(ServletContextEvent sce) {
                logger.info("ServletContext destroyed");
            }

        };
    }	

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Example.class, args);
	}

}