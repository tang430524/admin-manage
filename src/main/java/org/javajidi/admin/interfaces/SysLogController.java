package org.javajidi.admin.interfaces;

import org.javajidi.admin.application.SysLogService;
import org.javajidi.admin.domain.modle.SysLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

   
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<SysLog> list(){
        return sysLogService.list();
    }


}
