package org.bumishi.admin.interfaces.web;

import org.bumishi.admin.application.MenuService;
import org.bumishi.admin.domain.modle.Menu;
import org.bumishi.admin.interfaces.commondobject.MenuCreateCommand;
import org.bumishi.admin.interfaces.commondobject.MenuUpdateCommond;
import org.bumishi.admin.interfaces.facade.assembler.MenuAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author qiang.xie
 * @date 2016/9/18
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    protected MenuService menuService;

    @RequestMapping(method = RequestMethod.POST)
    public void create(@RequestBody MenuCreateCommand menu){
        menuService.create(MenuAssembler.createCommendToDomain(menu));
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void modify(@RequestBody MenuUpdateCommond menu){
        menuService.modify(MenuAssembler.updateCommendToDomain(menu));
    }



    @RequestMapping(value = "/{id}/status",method = RequestMethod.PUT)
    public void switchStatus(@PathVariable("id") String id,@RequestParam("disable") boolean disable){
        menuService.switchStatus(id,disable);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable("id")String id){
         menuService.delete(id);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Menu get(@PathVariable("id")String id){
        return menuService.get(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Menu> list(){
        return menuService.list();
    }


}
