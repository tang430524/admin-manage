package org.bumishi.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;

/**
 * Created by xieqiang on 2016/9/11.
 */
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
//@EnableAdminServer
public class Application {

    public static void main(String[] arg){
        SpringApplication.run(Application.class);
    }
}

