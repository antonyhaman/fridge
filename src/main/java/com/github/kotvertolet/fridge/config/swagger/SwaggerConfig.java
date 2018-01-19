package com.github.kotvertolet.fridge.config.swagger;

import com.github.kotvertolet.fridge.config.props.AppProperties;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDateTime;

//@Profile({"dev", "staging", "qa"})
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Lazy
    @Bean
    @Conditional({SwaggerCondition.class})
    public Docket itrafficApi(@Autowired AppProperties appProperties) {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName(appProperties.getDisplayName())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .build()
                .directModelSubstitute(LocalDateTime.class,
                        String.class)
                .enableUrlTemplating(false)
                .forCodeGeneration(true)
                .apiInfo(new ApiInfo(appProperties.getDisplayName(),
                        appProperties.getDescription(),
                        appProperties.getBuildNumber(),
                        "",
                        new Contact("FridgeCo", "", "anton.haman.92@gmail.com"),
                        "",
                        ""));
    }
}
