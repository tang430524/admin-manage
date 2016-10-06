package org.javajidi.admin.application;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.javajidi.admin.domain.modle.Menu;
import org.javajidi.admin.domain.modle.Resource;
import org.javajidi.admin.domain.modle.User;
import org.javajidi.admin.domain.repository.UserRepository;
import org.javajidi.admin.infrastructure.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by xieqiang on 2016/9/17.
 */
@Service
public class UserService {

    @Autowired
    protected UserRepository userRepository;

    @Autowired
    protected Md5PasswordEncoder md5PasswordEncoder;

    public void create(User user){
        validate(user);
        Assert.hasText(user.getPassword());
        user.setId(UUID.randomUUID().toString());
        user.setDisabled(false);
        user.setCreateTime(new Date());
        user.setSalt(RandomStringUtils.randomAscii(10));
        user.setPassword(md5PasswordEncoder.encodePassword(user.getPassword(),user.getSalt()));
        userRepository.add(user);
    }



    public void modify(User user){
        Assert.hasText(user.getId());
        User old=get(user.getId());
        if(StringUtils.isNotBlank(user.getUsername())){
            old.setUsername(user.getUsername());
        }
        if(StringUtils.isNotBlank(user.getPassword())){
            old.setPassword(md5PasswordEncoder.encodePassword(user.getPassword(), old.getSalt()));
        }
        if(StringUtils.isNotBlank(user.getEmail())) {
            old.setEmail(user.getEmail());
        }
        userRepository.update(old);
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


    private void validate(User user) {
        Assert.hasText(user.getUsername());
        if(user.isRoot()){
            throw new IllegalArgumentException("user loginName cannot is root");
        }
    }

}
