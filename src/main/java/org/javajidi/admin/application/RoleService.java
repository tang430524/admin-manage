package org.javajidi.admin.application;

import org.javajidi.admin.domain.modle.Role;
import org.javajidi.admin.domain.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.UUID;

/**
 * Created by xieqiang on 2016/9/17.
 */
@Service
public class RoleService {

    @Autowired
    protected RoleRepository roleRepository;

    public void create(Role role){
        Assert.hasText(role.getName(),"Role name is empty");
        if(roleRepository.contains(role.getName())){
            return;
        }
        role.setId(UUID.randomUUID().toString());
         roleRepository.add(role);
    }

    public void modify(Role newRole){
        Assert.hasText(newRole.getId(),"Role id is empty");
        Assert.hasText(newRole.getName(),"Role name is empty");
        roleRepository.update(newRole);
    }

    public Role get(String id){
        return roleRepository.get(id);
    }

    public List<Role> list(){
        return roleRepository.list();
    }

    public void delete(String id){
        roleRepository.remove(id);
    }

    public void switchStatus(String id,boolean disable){
        roleRepository.switchStatus(id,disable);
    }

    public void grantResource(String roleId, List<String> resources){
       Role role=get(roleId);
       role.grantResource(resources);
       roleRepository.update(role);
    }

    public void grantMenu(String roleId, List<String> menus){
        Role role=get(roleId);
        role.grantMenu(menus);
        roleRepository.update(role);
    }
}
