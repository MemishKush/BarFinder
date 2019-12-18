package com.project.barfinder.web.Interceptors;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class FavIconInterceptor extends HandlerInterceptorAdapter {
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
          String link = "http://icons.iconarchive.com/icons/iconsmind/outline/256/Martini-Glass-icon.png";

        if (modelAndView != null) {
            modelAndView.addObject("favicon", link);
        }
    }
}
