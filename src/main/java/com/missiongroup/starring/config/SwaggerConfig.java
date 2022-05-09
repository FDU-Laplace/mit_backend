package com.missiongroup.starring.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * SWAGGER配置类
 *
 * @author TAIHUAYUN
 * @date 2018-04-09 09:58
 */
@Configuration
@EnableSwagger2
@ConditionalOnProperty(prefix = "starring", name = "swagger-open", havingValue = "true")
public class SwaggerConfig {
	@Bean
	public Docket userApi() {
		String swagger_scan_tz_package = "com.missiongroup.starring.modular.system";
		ApiInfo apiInfo = new ApiInfoBuilder().title("接口文档").description("用户管理").build();
		return docketBuild(apiInfo, swagger_scan_tz_package, "用户管理");
	}
	@Bean
	public Docket vhisApi() {
		String swagger_scan_tz_package = "com.missiongroup.starring.modular.vhis.metro";
		ApiInfo apiInfo = new ApiInfoBuilder().title("接口文档").description("地铁管理").build();
		return docketBuild(apiInfo, swagger_scan_tz_package, "地铁管理");
	}
	@Bean
	public Docket faultApi() {
		String swagger_scan_tz_package = "com.missiongroup.starring.modular.vhis.fault";
		ApiInfo apiInfo = new ApiInfoBuilder().title("接口文档").description("故障配置").build();
		return docketBuild(apiInfo, swagger_scan_tz_package, "故障配置");
	}

	public Docket docketBuild(ApiInfo apiInfo, String swagger_scan_package, String groupName) {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName(groupName)
				.apiInfo(apiInfo)
				.select()
				.apis(RequestHandlerSelectors.basePackage(swagger_scan_package))//api接口包扫描路径
				.paths(PathSelectors.any())
				.build();
	}
}
