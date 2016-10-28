package org.bumishi.admin.interfaces.web;

import org.bumishi.admin.application.MenuService;
import org.bumishi.admin.domain.modle.Menu;
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
    public Menu create(@RequestBody Menu menu){
        menuService.create(menu);
        return menu;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void modify(@RequestBody Menu menu){
        menuService.modify(menu);
    }

    @RequestMapping(value = "/{code}/additem",method = RequestMethod.POST)
    public void addItem(@PathVariable("code") String code,@RequestBody Menu menu){
        menuService.addItem(code,menu);
    }


    @RequestMapping(value = "/{code}/status",method = RequestMethod.PUT)
    public void switchStatus(@PathVariable("code") String code,@RequestParam("disable") boolean disable){
        menuService.switchStatus(code,disable);
    }

    @RequestMapping(value = "/{code}",method = RequestMethod.DELETE)
    public void delete(@PathVariable("code")String code){
         menuService.delete(code);
    }

    @RequestMapping(value = "/{code}",method = RequestMethod.GET)
    public Menu get(@PathVariable("code")String code){
        return menuService.get(code);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Menu> list(){
        return menuService.list();
    }


}
