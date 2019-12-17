package com.project.barfinder.config;

import com.project.barfinder.web.Interceptors.LogInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ApplicationFilterConfiguration implements WebMvcConfigurer {
    private final LogInterceptor logInterceptor;

    @Autowired
    public ApplicationFilterConfiguration(LogInterceptor logInterceptor) {
        this.logInterceptor = logInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(logInterceptor);
    }
}
