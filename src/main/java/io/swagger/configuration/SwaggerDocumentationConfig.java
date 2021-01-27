package io.swagger.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.builders.RequestHandlerSelectors;


@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-12-31T21:15:33.955Z[GMT]")
@Configuration
public class SwaggerDocumentationConfig {

    ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Beneficiary account pre-validation (provider API)")
                .description("Move your app forward with the account pre-validation API.")
                .license("API Restricted License")
                .licenseUrl("https://www.swift.com/file/56776/download?token&#x3D;8w8DC4eF")
                .termsOfServiceUrl("https://developer.swift.com")
                .version("1.1.2")
                .contact(new Contact("","", "developer@swift.com"))
                .build();
    }
    @Bean
    public Docket customImplementation(){
        return new Docket(DocumentationType.OAS_30)
                .select()
                    .apis(RequestHandlerSelectors.basePackage("io.swagger.api"))
                    .build()
                .directModelSubstitute(org.threeten.bp.LocalDate.class, java.sql.Date.class)
                .directModelSubstitute(org.threeten.bp.OffsetDateTime.class, java.util.Date.class)
                .apiInfo(apiInfo());
    }
//    @Bean
//    public OpenAPI configure() {
//        return new OpenAPI()
//            .info(new Info()
//                .title("Beneficiary account pre-validation (provider API)")
//                .description("Move your app forward with the account pre-validation API.")
//                .termsOfService("https://developer.swift.com")
//                .version("1.1.2")
//                .license(new License()
//                    .name("API Restricted License")
//                    .url("https://www.swift.com/file/56776/download?token&#x3D;8w8DC4eF"))
//                .contact(new Contact()
//                    .email("developer@swift.com")));
//    }

}
