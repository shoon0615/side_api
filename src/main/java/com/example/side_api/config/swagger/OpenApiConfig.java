// 테스트 에선 번잡하기때문에 swagger 생략
/**
 * packageName  : com.example.side_api.config.swagger
 * fileName     : OpenApiConfig
 * author       : SangHoon
 * date         : 2023-10-03
 * description  : swagger 설정 파일
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023-10-03                SangHoon             최초 생성
 */
/*
package com.example.side_api.config.swagger;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class OpenApiConfig {

    @Bean
    public OpenApiConfig openAPI(@Value("v1.0") String appVersion) {
        Info info = new Info().title("Test API Docs").version(appVersion)
                .description("Spring Boot를 이용한 Test API Docs 입니다.")
                .termsOfService("http://swagger.io/terms/")
                .contact(new Contact().name("dejavuhyo").url("https://dejavuhyo.github.io/").email("dejavuhyo@gmail.com"))
                .license(new License().name("Apache License Version 2.0").url("http://www.apache.org/licenses/LICENSE-2.0"));

        return new OpenAPI()
                .components(new Components())
                .info(info);
    }
}*/
