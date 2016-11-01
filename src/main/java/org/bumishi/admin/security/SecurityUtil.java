package org.bumishi.admin.security;

import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by xieqiang on 2016/10/6.
 */
public class SecurityUtil {

    public static String getUid(){
        return getUser().getUid();
    }

    public static SecurityUser getUser() {
        return (SecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public static boolean isRoot() {
        return "root".equals(getUser().getUsername());
    }


}
