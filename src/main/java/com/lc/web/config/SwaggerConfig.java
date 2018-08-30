package com.lc.web.config;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import com.google.common.base.Predicate;
import org.springframework.boot.autoconfigure.web.BasicErrorController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * SwaggerConfig
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
    Predicate<RequestHandler> predicate = new Predicate<RequestHandler>() {
        @Override
        public boolean apply(RequestHandler input) {
            Class<?> declaringClass = input.declaringClass();
            if (declaringClass == BasicErrorController.class)// 排除
                return false;
            if(declaringClass.isAnnotationPresent(RestController.class)) // 被注解的类
                return true;
            if(input.isAnnotatedWith(ResponseBody.class)) // 被注解的方法
                return true;
            return false;
        }
    };
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("ser")
                .genericModelSubstitutes(DeferredResult.class)
//              .genericModelSubstitutes(ResponseEntity.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(false)
                .pathMapping("/")
                .select()
                .paths(or(regex("/.*")))//过滤的接口
                .build()
                .apiInfo(appApiInfo());
    }
    private ApiInfo appApiInfo() {
        return new ApiInfoBuilder()
                .title("后台 API")//大标题
                .description("EHR Platform的REST API，所有应用程序都可以通过JSON访问Object模型数据。")//详细描述
                .version("1.0")//版本
                .contact(new Contact("梁灿", "https://www.google.com.hk", "386740421@qq.com"))//作者
                .build();
    }
}