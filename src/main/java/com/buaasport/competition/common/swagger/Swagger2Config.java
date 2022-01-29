package com.buaasport.competition.common.swagger;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {

    private ApiInfo adminApiInfo(){
        return new ApiInfoBuilder()
                .title("北航体育赛事后台系统API文档")
                .description("描述各个API调用方法")
                .contact(new Contact("voutax", "https://atguigu.com","admain@gmail.com"))
                .build();
    }

    private ApiInfo webApiInfo(){
        return new ApiInfoBuilder()
                .title("北航体育赛事前台网站API文档")
                .description("描述各个网站API调用方法")
                .contact(new Contact("voutax", "https://atguigu.com","admain@gmail.com"))
                .build();
    }

    @Bean
    public Docket adminApiConfig() {
          return new Docket(DocumentationType.SWAGGER_2)
                  .groupName("adminApi")
                  .apiInfo(adminApiInfo())
                  .select()
                  .paths(Predicates.and(PathSelectors.regex("/admin/.*")))
                  .build();
    }

    @Bean
    public Docket webApiConfig() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("webApi")
                .apiInfo(webApiInfo())
                .select()
                .paths(Predicates.and(PathSelectors.regex("/api/.*")))
                .build();
    }
}
