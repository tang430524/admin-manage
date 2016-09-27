package org.javajidi.admin.interfaces;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qiang.xie
 * @date 2016/9/21
 */
@RestController
@RequestMapping("/public")
public class PublicController {



    @ExceptionHandler
    public void error(Throwable e){
        e.printStackTrace();
    }

}
