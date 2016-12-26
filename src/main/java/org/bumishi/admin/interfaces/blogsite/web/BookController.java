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
@RequestMapping("/blogsite/book")
public class BookController {

    @Autowired
    private BlogSiteRestTemplate restTemplate;

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    @ResponseBody
    public RestResponse create(@RequestBody String json) {
        return restTemplate.post("/admin/book/add", json);
    }

    @RequestMapping(value = "/{id}/modify", method = RequestMethod.POST)
    @ResponseBody
    public RestResponse modify(@PathVariable("id") String id, @RequestBody String json) {
        return restTemplate.post("/admin/book/" + id + "/update", json, id);
    }


    @RequestMapping(value = "/{id}/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public RestResponse delete(@PathVariable("id") String id) {
        return restTemplate.postWithEmptyBody("/admin/book/" + id + "/delete");
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String toform(@RequestParam(value = "id", required = false) String id, Model model) {
        String api = "/blogsite/book/add";
        if (StringUtils.isNotBlank(id)) {
            model.addAttribute("rep", restTemplate.getForObject("/admin/book/" + id));
            api = "/blogsite/book/" + id + "/modify";
        }
        model.addAttribute("api", api);

        return "blogsite/book/form";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model, @RequestParam(value = "page", required = false, defaultValue = "1") int page) {
        RestResponse<PageModel> response = restTemplate.getForPageModelResponseObject("/admin/book?page=" + page);
        model.addAttribute("rep", response);
        return "blogsite/book/list";
    }


    //book index
    @RequestMapping(method = RequestMethod.GET, value = "/{bookId}/indexs")
    public String indexList(Model model, @PathVariable("bookId") String bookId) {
        RestResponse response = restTemplate.getForObject("/admin/book/" + bookId + "/indexs");
        model.addAttribute("rep", response);
        return "blogsite/bookindex/list";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{bookId}/indexs/form")
    public String indexform(Model model, @PathVariable("bookId") String bookId, @RequestParam(value = "id", required = false) String id, @RequestParam(value = "parent", required = false) boolean parent) {
        String url = null;
        if (StringUtils.isNotBlank(id) && !parent) {
            model.addAttribute("rep", restTemplate.getForObject("/admin/bookindex/{id}", id));
            url = "/blogsite/book/" + bookId + "/indexs/" + id + "/modify";
        } else {
            url = "/blogsite/book/" + bookId + "/indexs/add";
            if (StringUtils.isNotBlank(id)) {
                model.addAttribute("parentPath", id);
            }
        }
        model.addAttribute("bookId", bookId);
        model.addAttribute("api", url);
        return "blogsite/bookindex/form";
    }


    @RequestMapping(method = RequestMethod.POST, value = "/{bookId}/indexs/add")
    @ResponseBody
    public RestResponse createIndex(@PathVariable("bookId") String bookId, @RequestBody String json) {
        return restTemplate.post("/admin/bookindex/{bookId}/add", json, bookId);
    }


    @RequestMapping(value = "/{bookId}/indexs/{id}/modify", method = RequestMethod.POST)
    @ResponseBody
    public RestResponse modifyIndex(@PathVariable("id") String id, @RequestBody String json) {
        return restTemplate.post("/admin/bookindex/{id}/modify", json, id);
    }


    @RequestMapping(value = "/indexs/{id}/status", method = {RequestMethod.POST, RequestMethod.PUT})
    @ResponseBody
    public RestResponse switchStatus(@PathVariable("id") String id, @RequestParam("disable") boolean disable) {
        return restTemplate.postWithEmptyBody("/admin/bookindex/{id}/status?disable=" + disable, id);
    }

    @RequestMapping(value = "/indexs/{id}/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public RestResponse deleteIndex(@PathVariable("id") String id) {
        return restTemplate.postWithEmptyBody("/admin/bookindex/{id}/delete", id);
    }
}
