package org.javajidi.admin.application;

import org.javajidi.admin.domain.modle.Menu;
import org.javajidi.admin.domain.modle.Resource;
import org.javajidi.admin.domain.modle.User;
import org.javajidi.admin.domain.repository.UserRepository;
import org.javajidi.admin.domain.services.UserPasswordEncodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.UUID;

/**
 * Created by xieqiang on 2016/9/17.
 */
@Service
public class UserService {

    @Autowired
    protected UserRepository userRepository;

    public void create(User user){
        validate(user);
        user.setId(UUID.randomUUID().toString());
        UserPasswordEncodeService.encodePassword(user);
        userRepository.add(user);
    }



    public void modify(User user){
        Assert.hasText(user.getId());
        validate(user);
        userRepository.update(user);
    }

    public void delete(String id){
        userRepository.remove(id);
    }

    public User get(String id){
        return userRepository.get(id);
    }

    public List<User> list(){
        return userRepository.list();
    }

    public void switchStatus(String id,boolean disable){
        userRepository.switchStatus(id,disable);
    }

    public List<Resource> getUrlResources(String uid){
        return userRepository.getUrlResources(uid);
    }

    public List<Menu> getNavMenus(String uid){
        return userRepository.getNavMenus(uid);
    }

    public boolean hasResourcePermission(String uid,String resourceCode){
        return userRepository.hasResourcePermission(uid,resourceCode);
    }

    public void grantRole(String uid,List<String> roleIds){
        User user=get(uid);
        user.grantRoles(roleIds);
        userRepository.update(user);
    }

    public User login(String loginName,String passwd){
        return userRepository.find(loginName,  UserPasswordEncodeService.encodePassword(passwd));
    }


    private void validate(User user) {
        Assert.hasText(user.getLoginName());
        Assert.hasText(user.getPassword());
        if(user.isRoot()){
            throw new IllegalArgumentException("user loginName cannot is root");
        }
    }

}
