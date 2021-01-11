package com.team.derivative.admin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author zhengxh
 */
@Configuration
public class CustomWebMvcConfig extends WebMvcConfigurerAdapter {


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                // 若要仅支持特定域名，就不写* 直接写域名
                .allowedOrigins("*")
                .allowedMethods(HttpMethod.POST.toString(), HttpMethod.GET.toString(),
                        HttpMethod.PUT.toString(), HttpMethod.DELETE.toString(),
                        HttpMethod.OPTIONS.toString())
                .maxAge(3600)
                .allowCredentials(true);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/resources/");
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
        super.addResourceHandlers(registry);
    }
}
