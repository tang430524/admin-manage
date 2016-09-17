package org.javajidi.admin.application;

import org.javajidi.admin.domain.repository.ResourceRepository;
import org.javajidi.admin.domain.modle.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xieqiang on 2016/9/17.
 */
@Service
public class ResourceService {

    @Autowired
    protected ResourceRepository resourceRepository;

    public void create(Resource resource){
        resourceRepository.add(resource);
    }

    public void modify(Resource resource){
        resourceRepository.update(resource);
    }

    public Resource get(String code){
        return resourceRepository.get(code);
    }

    public List<Resource> list(){
        return resourceRepository.list();
    }

    public void delete(String code){
        resourceRepository.remove(code);
    }
}
