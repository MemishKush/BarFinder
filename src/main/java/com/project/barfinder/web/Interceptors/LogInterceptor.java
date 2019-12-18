package com.project.barfinder.web.Interceptors;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class LogInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler)
            throws Exception {
        if(SecurityContextHolder.getContext().getAuthentication() != null) {
            if (SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                long startTime = System.currentTimeMillis();
                request.setAttribute("startTime", startTime);
                LocalDateTime dateTime = LocalDateTime.now();
                String currentTime = dtf.format(dateTime);
                String user = SecurityContextHolder.getContext().getAuthentication().getName();
                String url = request.getRequestURI();
                String method = request.getMethod();
                String asd = String.format("[%s] %s - performed %s request on URL: %s\r\n", currentTime, user, method, url);
                Files.write(Paths.get("log.txt"), asd.getBytes(), StandardOpenOption.APPEND);
            }
        }
        return true;

    }
}
