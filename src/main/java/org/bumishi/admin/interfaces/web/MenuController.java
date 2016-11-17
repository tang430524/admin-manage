package org.bumishi.admin.interfaces.web;

import org.apache.commons.lang3.StringUtils;
import org.bumishi.admin.application.MenuService;
import org.bumishi.admin.interfaces.facade.assembler.MenuAssembler;
import org.bumishi.admin.interfaces.facade.commondobject.MenuCreateCommand;
import org.bumishi.admin.interfaces.facade.commondobject.MenuUpdateCommond;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author qiang.xie
 * @date 2016/9/18
 */
@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    protected MenuService menuService;

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public String create(MenuCreateCommand menu) {
        menuService.create(MenuAssembler.createCommendToDomain(menu));
        return "redirect:/menu";
    }

    @RequestMapping(value = "/{id}/modify", method = RequestMethod.POST)
    public String modify(@PathVariable("id") String id, MenuUpdateCommond menu) {
        menuService.modify(MenuAssembler.updateCommendToDomain(id, menu));
        return "redirect:/menu";
    }


    @RequestMapping(value = "/{id}/status", method = RequestMethod.GET)
    public String switchStatus(@PathVariable("id") String id, @RequestParam("disable") boolean disable) {
        menuService.switchStatus(id,disable);
        return "redirect:/menu";
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable("id") String id) {
         menuService.delete(id);
        return "redirect:/menu";
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String toform(@RequestParam(value = "id", required = false) String id, Model model) {
        if (StringUtils.isNotBlank(id)) {
            model.addAttribute("menu", menuService.get(id));
        }
        return "menu/form";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("list", menuService.list());
        return "menu/list";
    }


}
