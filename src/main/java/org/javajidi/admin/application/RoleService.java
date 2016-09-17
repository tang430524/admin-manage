package org.javajidi.admin.application;

import org.javajidi.admin.domain.repository.RoleRepository;
import org.javajidi.admin.domain.modle.Menu;
import org.javajidi.admin.domain.modle.Resource;
import org.javajidi.admin.domain.modle.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created by xieqiang on 2016/9/17.
 */
@Service
public class RoleService {

    @Autowired
    protected RoleRepository roleRepository;

    public void create(String roleName,String desc){
        if(roleRepository.contains(roleName)){
            return;
        }
        Role role=new Role(UUID.randomUUID().toString(),roleName,desc);
         roleRepository.add(role);
    }

    public void modify(String id,String roleName,String desc){
        Role role=roleRepository.get(id);
        if(role!=null){
            role.update(roleName,desc);
            roleRepository.update(role);
        }
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

    public void grantResource(String roleId, List<Resource> resources){
       Role role=get(roleId);
       role.grantResource(resources);
       roleRepository.update(role);
    }

    public void grantMenu(String roleId, List<Menu> menus){
        Role role=get(roleId);
        role.grantMenu(menus);
        roleRepository.update(role);
    }
}
