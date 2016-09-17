package org.javajidi.admin.application;

import org.javajidi.admin.domain.modle.SysLog;
import org.javajidi.admin.domain.repository.SysLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xieqiang on 2016/9/17.
 */
@Service
public class SysLogService {

    @Autowired
    protected SysLogRepository sysLogRepository;

    public void create(SysLog sysLog){
        sysLogRepository.add(sysLog);
    }

    public void clear(){
        sysLogRepository.clear();
    }

    public List<SysLog> list(){
        return sysLogRepository.list();
    }
}
