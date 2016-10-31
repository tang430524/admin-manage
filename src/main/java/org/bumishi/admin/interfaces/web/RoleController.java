package org.bumishi.admin.interfaces.web;

import org.bumishi.admin.application.RoleService;
import org.bumishi.admin.domain.modle.Role;
import org.bumishi.admin.domain.modle.SelectMenu;
import org.bumishi.admin.domain.modle.SelectResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author qiang.xie
 * @date 2016/9/18
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    protected RoleService roleService;

    @RequestMapping(method = RequestMethod.POST)
    public void create(@RequestBody Role role){
        roleService.create(role);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void modify(@PathVariable("id") String id, @RequestBody Role role) {
        role.setId(id);
        roleService.modify(role);
    }

    @RequestMapping(value = "/{id}/status",method = RequestMethod.PUT)
    public void switchStatus(@PathVariable("id") String id,@RequestParam("disable") boolean disable){
        roleService.switchStatus(id,disable);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable("id")String id){
         roleService.delete(id);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Role get(@PathVariable("id")String id){
        return roleService.get(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Role> list(){
        return roleService.list();
    }

    @RequestMapping(value = "/{id}/select-resource", method = RequestMethod.GET)
    public List<SelectResource> selectRole(@PathVariable("id") String id) {
        return roleService.selectResources(id);
    }

    @RequestMapping(value = "/{id}/select-menu", method = RequestMethod.GET)
    public List<SelectMenu> selectMenu(@PathVariable("id") String id) {
        return roleService.selectMenus(id);
    }

    //为角色分配资源
    @RequestMapping(value = "/{id}/grant-resource",method = RequestMethod.PUT)
    public void grantResources(@PathVariable("id") String id, @RequestBody List<SelectResource> rids) {
        roleService.grantResource(id, rids.stream().filter(selectResource -> selectResource.isChecked()).map(selectResource -> selectResource.getRid()).collect(Collectors.toList()));
    }

    //为角色分配菜单
    @RequestMapping(value = "/{id}/grant-menu",method = RequestMethod.PUT)
    public void grantMenu(@PathVariable("id") String id, @RequestBody List<SelectMenu> menuCodes) {
        roleService.grantMenu(id, menuCodes.stream().filter(selectMenu -> selectMenu.isChecked()).map(selectMenu -> selectMenu.getMid()).collect(Collectors.toList()));
    }

}
