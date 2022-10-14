package com.yujianyou.config;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;

import javax.ws.rs.core.Application;

/**
 * @author yujianyou
 * @date 2021/11/19 11:43
 * @email 597907730@qq.com
 */
@OpenAPIDefinition(
        info = @Info(
                title = "Quarkus快速开发脚手架",
                version = "1.0.0",
                description = "Quarkus快速开发脚手架",
                contact = @Contact(
                        name = "Jannyyyy",
                        url = "http://yujianyou.com.cn",
                        email = "597907730@qq.com")
        )
)
public class SwaggerConfig extends Application {
}
