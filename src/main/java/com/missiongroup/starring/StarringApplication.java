package com.missiongroup.starring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.missiongroup.starring.config.properties.StarringProperties;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class StarringApplication extends WebMvcConfigurerAdapter {
	protected final static Logger logger = LoggerFactory.getLogger(StarringApplication.class);

	@Autowired
	StarringProperties starringProperties;

	/**
	 * 增加swagger的支持
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		if (starringProperties.getSwaggerOpen()) {
			registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
			registry.addResourceHandler("doc.html").addResourceLocations("classpath:/META-INF/resources/");
			registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(StarringApplication.class, args);
		logger.info("StarringApplication is success!");
	}
}
