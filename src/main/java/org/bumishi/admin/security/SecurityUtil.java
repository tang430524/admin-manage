package org.bumishi.admin.security;

import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by xieqiang on 2016/10/6.
 */
public class SecurityUtil {

    public static String getUid(){
        SecurityUser su=(SecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return su.getUid();
    }


}
