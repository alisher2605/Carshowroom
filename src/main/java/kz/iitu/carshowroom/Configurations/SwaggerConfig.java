package kz.iitu.carshowroom.Configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("kz.iitu.carshowroom"))
                .paths(PathSelectors.ant("/api/**"))
                .build()
                .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo (){
        ApiInfo apiInfo = new ApiInfo(
                "Spring Boot Swagger2",
                "Spring Boot Swagger2 Api Documentation for Library management system",
                "1.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new Contact("Alisher Zharmukhambetov",
                        "https://github.com/alisher2605/Assignment7","alisher.zharmukhambetov@gmail.com"),
                "License 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<>());
        return apiInfo;
    }
}
