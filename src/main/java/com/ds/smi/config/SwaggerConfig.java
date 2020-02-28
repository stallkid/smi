package com.ds.smi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	private static final String DEFAULT_INCLUDE_PATTERN = "/.*";
	
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2).select()                                  
          .apis(RequestHandlerSelectors.basePackage("com.ds.smi.controllers"))
          .paths(PathSelectors.regex(DEFAULT_INCLUDE_PATTERN))
          .build().apiInfo(apiEndPointInfo());
        }
    
    private ApiInfo apiEndPointInfo() {
    	Contact contact = new Contact("Unip 2020", "https://www.unip.br", "ccunip@outlook.com.br");
    	return new ApiInfoBuilder().title("Spring Boot SMI APIs")
    			.description("Esta página mostra todas as APIs do Backend")
    			.contact(contact)
    			.license("Apache 2.0")
    			.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
    			.version("1.0.0")
    			.build();
    }
}

