package com.cq.demo.filter;

import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Author: ChengYangChang
 */
@Component
public class FilterConfig {

    @Bean
    public RemoteIpFilter remoteIpFilter() {
        return new RemoteIpFilter();
    }

    @Bean
    public FilterRegistrationBean userCenterFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();

        // 添加过滤器
        registration.setFilter(new LoginFilter());
        registration.setName("loginFilter");
        registration.addUrlPatterns("/*");// 设置过滤路径
        registration.setOrder(1);// 设置优先级

        // 添加默认参数
        return registration;
    }

}
