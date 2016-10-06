package org.javajidi.admin.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * @author qiang.xie
 * @date 2016/9/27
 */
public class SecurityUser extends User {
    private String uid;
    private String salt;

    public SecurityUser(String uid,String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities, String salt) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.salt = salt;
        this.uid=uid;
    }

    public String getSalt() {
        return salt;
    }

    public String getUid() {
        return uid;
    }
}
