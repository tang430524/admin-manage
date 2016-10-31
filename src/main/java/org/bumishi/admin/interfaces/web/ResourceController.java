package org.bumishi.admin.interfaces.web;

import org.bumishi.admin.application.ResourceService;
import org.bumishi.admin.domain.modle.Resource;
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
    public void create(@RequestBody Resource resource){
        resourceService.create(resource);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void modify(@PathVariable("id") String id, @RequestBody Resource resource) {
        resource.setId(id);
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

    @RequestMapping(method = RequestMethod.GET)
    public List<Resource> list(){
        return resourceService.list();
    }


}
