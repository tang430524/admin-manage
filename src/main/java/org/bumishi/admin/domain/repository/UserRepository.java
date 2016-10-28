package org.bumishi.admin.domain.repository;

import org.bumishi.admin.domain.modle.Menu;
import org.bumishi.admin.domain.modle.Resource;
import org.bumishi.admin.domain.modle.Role;
import org.bumishi.admin.domain.modle.User;

import java.util.List;

/**
 * Created by xieqiang on 2016/9/17.
 */
public interface UserRepository {

    void add(User user);

    void update(User user);

    User get(String id);

    boolean contains(String name);

    List<User> list();

    List<Resource> getUrlResources(String userId);

    boolean hasResourcePermission(String userId,String resourceCode);

    List<Menu> getNavMenus(String userId);

    void remove(String id);

    void switchStatus(String id,boolean disabled);


    User findByUserName(String username);

    List<Role> getRoles(String userId);


}
