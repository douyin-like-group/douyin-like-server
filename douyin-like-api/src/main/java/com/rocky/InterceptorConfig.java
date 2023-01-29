package com.rocky;


import com.rocky.intercepter.UserTokenInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {



    @Bean
    public UserTokenInterceptor userTokenInterceptor() {
        return new UserTokenInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {


        registry.addInterceptor(userTokenInterceptor())
                .addPathPatterns("/douyin/user/")
                .addPathPatterns("/douyin/publish/action/");
    }
}
