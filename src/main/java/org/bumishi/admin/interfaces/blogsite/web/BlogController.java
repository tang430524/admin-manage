package org.bumishi.admin.interfaces.blogsite.web;

import org.apache.commons.lang3.StringUtils;
import org.bumishi.admin.interfaces.blogsite.BlogSiteRestTemplate;
import org.bumishi.toolbox.model.PageModel;
import org.bumishi.toolbox.model.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author qiang.xie
 * @date 2016/12/7
 */
@Controller
@RequestMapping("/blogsite/blog")
public class BlogController {

    @Autowired
    private BlogSiteRestTemplate restTemplate;

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    @ResponseBody
    public RestResponse create(@RequestBody String json) {
        return restTemplate.post("/admin/blog/add", json);
    }

    @RequestMapping(value = "/{id}/modify", method = RequestMethod.POST)
    @ResponseBody
    public RestResponse modify(@PathVariable("id") String id, @RequestBody String json) {
        return restTemplate.post("/admin/blog/" + id + "/update", json, id);
    }


    @RequestMapping(value = "/{id}/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public RestResponse delete(@PathVariable("id") String id) {
        return restTemplate.postWithEmptyBody("/admin/blog/" + id + "/delete");
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String toform(@RequestParam(value = "id", required = false) String id, Model model) {
        String api = "/blogsite/blog/add";
        if (StringUtils.isNotBlank(id)) {
            model.addAttribute("rep", restTemplate.getForObject("/admin/blog/" + id));
            api = "/blogsite/blog/" + id + "/modify";
        }
        model.addAttribute("api", api);

        return "blogsite/blog/form";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model, @RequestParam(value = "page", required = false, defaultValue = "1") int page) {
        RestResponse<PageModel> response = restTemplate.getForPageModelResponseObject("/admin/blog?page=" + page);//todo 不能正确反序列化
        model.addAttribute("rep",response);
        return "blogsite/blog/list";
    }


}
