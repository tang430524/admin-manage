package org.javajidi.admin.application;

import org.javajidi.admin.domain.modle.Menu;
import org.javajidi.admin.domain.modle.Resource;
import org.javajidi.admin.domain.modle.User;
import org.javajidi.admin.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xieqiang on 2016/9/17.
 */
@Service
public class UserService {

    @Autowired
    protected UserRepository userRepository;

    public void create(User user){
        userRepository.add(user);
    }

    public void modify(User user){
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

    public List<Resource> getUrlResources(String userId){
        return userRepository.getUrlResources(userId);
    }

    public List<Menu> getNavMenus(String userId){
        return userRepository.getNavMenus(userId);
    }

    public boolean hasResourcePermission(String resourceCode){
        return userRepository.hasResourcePermission(resourceCode);
    }


}
