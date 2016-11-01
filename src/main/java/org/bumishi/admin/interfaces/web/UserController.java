package org.bumishi.admin.interfaces.web;

import org.bumishi.admin.application.MenuService;
import org.bumishi.admin.application.UserService;
import org.bumishi.admin.domain.modle.Menu;
import org.bumishi.admin.domain.modle.SelectRole;
import org.bumishi.admin.interfaces.commondobject.UserCommond;
import org.bumishi.admin.interfaces.facade.assembler.UserAssembler;
import org.bumishi.admin.interfaces.facade.dto.UserDto;
import org.bumishi.admin.security.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author qiang.xie
 * @date 2016/9/18
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    protected UserService userService;

    @Autowired
    protected MenuService menuService;

    @RequestMapping(method = RequestMethod.POST)
    public void create(@RequestBody UserCommond user){
        userService.create(UserAssembler.commondToDomain(user));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void modify(@PathVariable("id") String id, @RequestBody UserCommond user) {
        userService.modify(UserAssembler.commondToDomain(id, user));
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

    @RequestMapping(value = "/{id}/grantRole",method = RequestMethod.PUT)
    public void grantRole(@PathVariable("id") String id, @RequestBody List<SelectRole> rids) {
        userService.grantRole(id, rids.stream().filter(selectRole -> selectRole.isChecked()).map(selectRole -> selectRole.getRid()).collect(Collectors.toList()));
    }

    @RequestMapping(value = "/nav",method = RequestMethod.GET)
    public List<Menu> myMenus() {
        return menuService.getNavMenus(SecurityUtil.getUid());
    }

    @RequestMapping(value = "/{id}/select-role", method = RequestMethod.GET)
    public List<SelectRole> selectRole(@PathVariable("id") String id) {
        return userService.selectRoles(id);
    }

}
