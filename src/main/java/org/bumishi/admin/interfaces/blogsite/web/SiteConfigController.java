package org.bumishi.admin.interfaces.blogsite.web;

import org.bumishi.admin.interfaces.blogsite.BlogSiteRestTemplate;
import org.bumishi.toolbox.model.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by xieqiang on 2017/1/4.
 */
@Controller
@RequestMapping("/blogsite/siteconfig")
public class SiteConfigController {

    @Autowired
    private BlogSiteRestTemplate restTemplate;


    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    @ResponseBody
    public RestResponse modify(@RequestBody String json) {
        return restTemplate.post("/admin/siteconfig/update", json);
    }


    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String toform(Model model) {
        String api = "/blogsite/siteconfig/modify";
        model.addAttribute("rep", restTemplate.getForObject("/admin/siteconfig"));
        model.addAttribute("api", api);
        return "blogsite/siteconfig/form";
    }

}
