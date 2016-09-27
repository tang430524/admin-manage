package org.javajidi.admin.domain.repository;

import org.javajidi.admin.domain.modle.Role;

import java.util.List;

/**
 * Created by xieqiang on 2016/9/17.
 */
public interface RoleRepository {

    void add(Role role);

    void update(Role role);

    boolean contains(String roleName);

    Role get(String id);

    List<Role> list();

    void remove(String id);

    void switchStatus(String id,boolean disabled);


}
