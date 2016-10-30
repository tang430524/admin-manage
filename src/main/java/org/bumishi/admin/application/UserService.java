package org.bumishi.admin.application;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.bumishi.admin.domain.modle.Menu;
import org.bumishi.admin.domain.modle.SelectRole;
import org.bumishi.admin.domain.modle.TreeModel;
import org.bumishi.admin.domain.modle.User;
import org.bumishi.admin.domain.repository.MenuRepository;
import org.bumishi.admin.domain.repository.RoleRepository;
import org.bumishi.admin.domain.repository.UserRepository;
import org.bumishi.admin.domain.service.RoleSelectService;
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

    @Autowired
    protected RoleSelectService roleSelectService;

    @Autowired
    protected RoleRepository roleRepository;

    @Autowired
    protected MenuRepository menuRepository;


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

    public List<Menu> getNavMenus(String uid){
        List<Menu> list = menuRepository.getNavMenus(uid);
        return (List<Menu>) TreeModel.buildTree(list);
    }

    public boolean hasResourcePermission(String uid,String resourceCode){
        return userRepository.hasResourcePermission(uid,resourceCode);
    }

    public void grantRole(String uid,List<String> roleIds){
        userRepository.updateRoles(uid, roleIds);
    }


    private void validate(User user) {
        Assert.hasText(user.getUsername());
        if(user.isRoot()){
            throw new IllegalArgumentException("user loginName cannot is root");
        }
    }

    public List<SelectRole> selectRoles(String uid) {
        return roleSelectService.mergeRole(roleRepository.list(), roleRepository.getRoles(uid));
    }

}
