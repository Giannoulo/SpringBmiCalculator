package com.fit.bmi.config;

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
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
                .apiInfo(metaData());
    }

    /**
     * Metadata to Swagger
     */

    private ApiInfo metaData() {
        Contact contact = new Contact("George & Thanos", "https://github.com/Giannoulo/SpringBmiCalculator", "thanosloukeris@gmail.com");
        return new ApiInfoBuilder()
                .title("Dummy project for awesome devs")
                .description("An api to see how awesome we are!")
                .contact(contact)
                .build();
    }

}
