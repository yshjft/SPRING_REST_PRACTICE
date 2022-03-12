package com.jerry.restpractice.global.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    private static final Contact DEFAULT_CONTACT = new Contact("jerry",
            "https://velog.io/@yshjft", "jericoh@naver.coms");

    private static final ApiInfo DEFAULT_API_INFO = new ApiInfo("rest api practice", "for rest api practice", "1.0", "urn:tos",
            DEFAULT_CONTACT, "Apache 2.0",
            "http://www.apache.org.license/LICENSE-2.0", new ArrayList<>());

    // 어떠한 형태로 데이터를 사용할 수 있는지 지정
    private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<>(Arrays.asList("application/json", "application/xml"));

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(DEFAULT_API_INFO) // 옵션 사항(필수X)
                .produces(DEFAULT_PRODUCES_AND_CONSUMES) // 옵션 사항(필수X)
                .consumes(DEFAULT_PRODUCES_AND_CONSUMES); // 옵션 사항(필수X)
    }
}
