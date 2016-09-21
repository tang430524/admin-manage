package org.javajidi.admin.interfaces;

import org.javajidi.admin.application.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qiang.xie
 * @date 2016/9/21
 */
@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    protected UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public void login(@RequestParam("uname") String uname,@RequestParam("passwd")String password){
        userService.login(uname,password);
    }

}
