package org.javajidi.admin.domain.services;

import org.apache.tomcat.util.security.MD5Encoder;
import org.javajidi.admin.domain.modle.User;
import org.springframework.util.StringUtils;

/**
 * Created by xieqiang on 2016/9/17.
 */
public class UserPasswordEncodeService {

    public static void encodePassword(User user){
        if(user==null || StringUtils.isEmpty(user.getPassword())){
            return;
        }
        user.setPassword(MD5Encoder.encode(user.getPassword().getBytes()));
    }

    public static String encodePassword(String password){
        return MD5Encoder.encode(password.getBytes());
    }
}
