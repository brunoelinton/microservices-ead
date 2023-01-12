package com.ead.course.controllers.configs;

import net.kaczmarzyk.spring.data.jpa.web.SpecificationArgumentResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

@Configuration
public class ResolverConfig extends WebMvcConfigurationSupport {

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argmentResolvers) {
        argmentResolvers.add(new SpecificationArgumentResolver());

        PageableHandlerMethodArgumentResolver resolver = new PageableHandlerMethodArgumentResolver();
        argmentResolvers.add(resolver);
        super.addArgumentResolvers(argmentResolvers);
    }
}
