package org.javajidi.admin.interfaces.web;

import org.javajidi.admin.application.UserService;
import org.javajidi.admin.domain.modle.Menu;
import org.javajidi.admin.interfaces.commondobject.UserCommond;
import org.javajidi.admin.interfaces.facade.assembler.UserAssembler;
import org.javajidi.admin.interfaces.facade.dto.UserDto;
import org.javajidi.admin.security.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    public void create(@RequestBody UserCommond user){
        userService.create(UserAssembler.commondToDomain(user));
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void modify(@RequestBody UserCommond user){
        userService.modify(UserAssembler.commondToDomain(user));
    }

    @RequestMapping(value = "/{id}/status",method = RequestMethod.PUT)
    public void switchStatus(@PathVariable("id") String id,@RequestParam("disable") boolean disable){
        userService.switchStatus(id,disable);
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable("id")String id){
         userService.delete(id);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public UserDto get(@PathVariable("id")String id){
        return UserAssembler.domainToDto(userService.get(id));
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<UserDto> list(){
        return UserAssembler.domainToDto(userService.list());
    }

    @RequestMapping(value = "/grantRole",method = RequestMethod.PUT)
    public void grantRole(@PathVariable("id") String id,@RequestBody List<String> rids){
        userService.grantRole(id,rids);
    }

    @RequestMapping(value = "/nav",method = RequestMethod.GET)
    public List<Menu> myMenus(HttpServletRequest request){
        return userService.getNavMenus(SecurityUtil.getUid());
    }

}
