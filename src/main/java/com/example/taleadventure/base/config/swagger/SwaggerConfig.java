package com.example.taleadventure.base.config.swagger;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


@Configuration
public class SwaggerConfig {

    private Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(this.apiInfo()) // ApiInfo 설정
                .useDefaultResponseMessages(false)
                .groupName("TaleAdventureApi")
                .select()
                .apis(RequestHandlerSelectors.
                        basePackage("com.example.taleadventure.domain"))
                .paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("TaleAdventure")
                .description("TaleAdventure의 API 명세서")
                .version("0.0.1")
                .contact(new Contact("Dae Hui Shin", "https://newdaycoding.tistory.com/", "sdhdream99@gmail.com"))
                .build();
    }
}