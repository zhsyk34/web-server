package com.dnk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.dnk.repository"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

//    @Bean
//    public EmbeddedServletContainerCustomizer containerCustomizer() {
//
//        return (container -> {
//            ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/401.html");
//            ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/404.html");
//            ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500.html");
//
//            container.addErrorPages(error401Page, error404Page, error500Page);
//        });
//    }
}
