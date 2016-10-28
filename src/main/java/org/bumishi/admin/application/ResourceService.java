package org.bumishi.admin.application;

import org.bumishi.admin.domain.modle.Resource;
import org.bumishi.admin.domain.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.UUID;

/**
 * Created by xieqiang on 2016/9/17.
 */
@Service
public class ResourceService {

    @Autowired
    protected ResourceRepository resourceRepository;

    public void create(Resource resource){
        validate(resource);
        resource.setId(UUID.randomUUID().toString());
        resourceRepository.add(resource);
    }


    public void modify(Resource resource){
        validate(resource);
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

    public void switchStatus(String code,boolean disable){
        resourceRepository.switchStatus(code,disable);
    }
    private void validate(Resource resource) {
        Assert.hasText(resource.getTitle());
        Assert.hasText(resource.getUrl());

    }
}
