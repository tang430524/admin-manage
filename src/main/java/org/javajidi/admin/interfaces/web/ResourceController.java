package org.javajidi.admin.interfaces.web;

import org.javajidi.admin.application.ResourceService;
import org.javajidi.admin.domain.modle.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author qiang.xie
 * @date 2016/9/18
 */
@RestController
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    protected ResourceService resourceService;

    @RequestMapping(method = RequestMethod.POST)
    public Resource create(@RequestBody Resource resource){
        resourceService.create(resource);
        return resource;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void modify(@RequestBody Resource resource){
        resourceService.modify(resource);
    }

    @RequestMapping(value = "/{code}/status",method = RequestMethod.PUT)
    public void switchStatus(@PathVariable("code") String code,@RequestParam("disable") boolean disable){
        resourceService.switchStatus(code,disable);
    }

    @RequestMapping(value = "/{code}",method = RequestMethod.DELETE)
    public void delete(@PathVariable("code")String code){
         resourceService.delete(code);
    }

    @RequestMapping(value = "/{code}",method = RequestMethod.GET)
    public Resource get(@PathVariable("code")String code){
        return resourceService.get(code);
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<Resource> list(){
        return resourceService.list();
    }


}
