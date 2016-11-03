package org.bumishi.admin;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by xieqiang on 2016/9/11.
 */
@SpringBootApplication
@EnableAdminServer
public class Application {

    public static void main(String[] arg){
        SpringApplication.run(Application.class);
    }
}

