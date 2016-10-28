package org.bumishi.admin.interfaces.web;

import org.bumishi.admin.application.SysLogService;
import org.bumishi.admin.domain.modle.SysLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author qiang.xie
 * @date 2016/9/18
 */
@RestController
@RequestMapping("/syslog")
public class SysLogController {

    @Autowired
    protected SysLogService sysLogService;

    

    @RequestMapping(method = RequestMethod.DELETE)
    public void clear(){
         sysLogService.clear();
    }

   
    @RequestMapping(method = RequestMethod.GET)
    public List<SysLog> list(){
        return sysLogService.list();
    }


}
