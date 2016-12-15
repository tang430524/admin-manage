package org.bumishi.admin.interfaces.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
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
        RestResponse restResponse = new RestTemplate().postForObject(blogConfig.getBlogHost() + "/admin/blog/add", command, RestResponse.class);
        if (restResponse.success()) {
            return "redirect:/blog";
        }
        return "blog/form";
    }

    @RequestMapping(value = "/{id}/modify", method = RequestMethod.POST)
    public String modify(@PathVariable("id") String id, AddBlogCommand command) {
        RestResponse restResponse = new RestTemplate().postForObject(blogConfig.getBlogHost() + "/admin/blog/update", command, RestResponse.class);
        if (restResponse.success()) {
            return "redirect:/blog";
        }
        return "blog/form";
    }


    @RequestMapping(value = "/{id}/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable("id") String id) {
        new RestTemplate().delete(blogConfig.getBlogHost() + "/admin/blog/{id}/delete", id);
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
        String json = new RestTemplate().getForObject(blogConfig.getBlogHost() + "/rest/blog/latest", String.class);
        RestResponse<PageModel<AddBlogCommand>> response = JSON.parseObject(json, new TypeReference<RestResponse<PageModel<AddBlogCommand>>>() {
        });
        model.addAttribute("pageModel", response.getData());
        return "blog/list";
    }


}
