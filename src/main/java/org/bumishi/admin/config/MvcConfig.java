package org.bumishi.admin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author qiang.xie
 * @date 2016/11/16
 */
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/to-login").setViewName("login");
//        registry.addViewController("/404").setViewName("err404");
//        registry.addViewController("/401").setViewName("401");
        registry.addViewController("/error").setViewName("error/error");

    }


}
