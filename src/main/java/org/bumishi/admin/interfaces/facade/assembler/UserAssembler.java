package org.bumishi.admin.interfaces.facade.assembler;

import org.bumishi.admin.domain.modle.User;
import org.bumishi.admin.infrastructure.BeanUtil;
import org.bumishi.admin.interfaces.commondobject.UserCommond;
import org.bumishi.admin.interfaces.facade.dto.UserDto;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiang.xie
 * @date 2016/9/29
 */
public class UserAssembler {

    public static User commondToDomain(UserCommond commond) {
        User user=new User();
//        user.setUsername(commond.getUsername());
//        user.setEmail(commond.getEmail());
//        user.setPassword(commond.getPassword());
        BeanUtil.copeProperties(commond,user);
        return user;
    }

    public static UserDto domainToDto(User user){
        UserDto dto=new UserDto();
       BeanUtil.copeProperties(user,dto);
        return dto;
    }

    public static List<UserDto> domainToDto(List<User> user){
       if(CollectionUtils.isEmpty(user)){
           return null;
       }
        List<UserDto> dtos=new ArrayList<>(user.size());
        user.stream().forEach(user1 -> {
            dtos.add(domainToDto(user1));
        });
        return dtos;
    }

}
