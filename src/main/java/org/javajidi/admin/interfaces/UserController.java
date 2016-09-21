package org.javajidi.admin.interfaces;

import org.javajidi.admin.application.UserService;
import org.javajidi.admin.domain.modle.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author qiang.xie
 * @date 2016/9/18
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    protected UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public User create(@RequestBody User user){
        userService.create(user);
        return user;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void modify(@RequestBody User user){
        userService.modify(user);
    }

    @RequestMapping(value = "/{id}/disable",method = RequestMethod.PUT)
    public void switchStatus(@PathVariable("id") String id,@RequestParam("disable") boolean disable){
        userService.switchStatus(id,disable);
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable("id")String id){
         userService.delete(id);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public User get(@PathVariable("id")String id){
        return userService.get(id);
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<User> list(){
        return userService.list();
    }

    @RequestMapping(value = "/grantRole",method = RequestMethod.PUT)
    public void grantRole(@PathVariable("id") String id,@RequestBody List<String> rids){
        userService.grantRole(id,rids);
    }


}
