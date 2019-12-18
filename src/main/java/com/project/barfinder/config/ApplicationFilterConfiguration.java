package com.project.barfinder.config;

import com.project.barfinder.web.Interceptors.FavIconInterceptor;
import com.project.barfinder.web.Interceptors.LogInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ApplicationFilterConfiguration implements WebMvcConfigurer {
    private final LogInterceptor logInterceptor;
    private final FavIconInterceptor favIconInterceptor;

    @Autowired
    public ApplicationFilterConfiguration(LogInterceptor logInterceptor, FavIconInterceptor favIconInterceptor) {
        this.logInterceptor = logInterceptor;
        this.favIconInterceptor = favIconInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(logInterceptor);
        registry.addInterceptor(favIconInterceptor);
    }
}
