package org.javajidi.admin.security;

import org.javajidi.admin.domain.modle.Role;
import org.javajidi.admin.domain.modle.User;
import org.javajidi.admin.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * @author qiang.xie
 * @date 2016/9/27
 */
@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    protected UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepository.findByUserName(username);
        if(user==null){
            throw new UsernameNotFoundException("no user");
        }
        SecurityUser userDetails=new SecurityUser(user.getId(),username,user.getPassword(),!user.isDisabled(),true,true,true,grantedAuthorities(user.getId()),user.getSalt());
        return userDetails;
    }

    protected Collection<GrantedAuthority> grantedAuthorities(String userId){
        List<Role> resources=userRepository.getRoles(userId);
        if(CollectionUtils.isEmpty(resources)){
            return new ArrayList<>();
        }
        Collection<GrantedAuthority> authorities=new HashSet<>();
        resources.stream().forEach((resource -> {
            authorities.add(new SimpleGrantedAuthority(resource.getName()));
        }));
        return authorities;
    }

}
