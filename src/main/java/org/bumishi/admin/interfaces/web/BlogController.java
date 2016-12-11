package org.bumishi.admin.interfaces.web;

import org.apache.commons.lang3.StringUtils;
import org.bumishi.admin.config.BlogConfig;
import org.bumishi.admin.interfaces.command.AddBlogCommand;
import org.bumishi.toolbox.model.PageModel;
import org.bumishi.toolbox.model.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author qiang.xie
 * @date 2016/12/7
 */
@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    protected BlogConfig blogConfig;

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public String create(AddBlogCommand command) {
         new RestTemplate().postForObject(blogConfig.getBlogHost()+"/admin/blog/add",command, RestResponse.class);
        return "redirect:/blog";
    }

    @RequestMapping(value = "/{id}/modify", method = RequestMethod.POST)
    public String modify(@PathVariable("id") String id, AddBlogCommand command) {
        System.out.println(command);

        return "redirect:/blog";
    }


    @RequestMapping(value = "/{id}/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable("id") String id) {
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String toform(@RequestParam(value = "id", required = false) String id, Model model) {
        String api = "/blog/add";
        if (StringUtils.isNotBlank(id)) {

            api = "/blog/" + id + "/modify";
        }
        model.addAttribute("api", api);

        return "blog/form";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        PageModel pageModel=(PageModel) new RestTemplate().getForObject(blogConfig.getBlogHost()+"/rest/blog/latest",RestResponse.class).getData();
        model.addAttribute("list",pageModel.getList());
        return "blog/list";
    }


}
