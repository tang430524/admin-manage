package org.javajidi.admin.security;

import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

/**
 * spring security默认的url授权方式需要预先硬编码在配置中，这里改写默认方式
 * @author qiang.xie
 * @date 2016/9/23
 */
public class UrlSecurityInterceptor extends FilterSecurityInterceptor {
}
