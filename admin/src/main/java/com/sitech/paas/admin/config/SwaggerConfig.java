package com.sitech.paas.admin.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.HashSet;

/**
 * swagger配置类
 *
 * @author huangzb
 * @date 2022/4/24
 */

@RequiredArgsConstructor
@EnableOpenApi
@Configuration
public class SwaggerConfig {
    @Value("swagger.enabled")
    private String enabled;
    @Value("server.port")
    private String port;



    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30).pathMapping("/")
                .enable(Boolean.parseBoolean(enabled))


                // 将api的元信息设置为包含在json ResourceListing响应中。
                .apiInfo(apiInfo())

                // 接口调试地址
                .host("http://localhost:" + port)

                // 关闭默认状态码
                .useDefaultResponseMessages(false)

                // 选择哪些接口作为swagger的doc发布
                .select()
                // 接口扫描方案
                .apis(RequestHandlerSelectors.basePackage("com.sitech.paas"))
                .paths(PathSelectors.any())
                .build()
                // 支持的通讯协议集合
                .protocols(getProtocols());
    }

    private HashSet<String> getProtocols() {
        HashSet<String> set = new HashSet<>();
        set.add("https");
        set.add("http");
        return set;
    }

    /**
     * API 页面上半部分展示信息
     */
    private ApiInfo apiInfo() {

        return new ApiInfoBuilder().title("open_eyes 2.0告警系统 Api Doc")
                .description("rest接口文档")
                .version("v1.0")
                .build();
    }
}
