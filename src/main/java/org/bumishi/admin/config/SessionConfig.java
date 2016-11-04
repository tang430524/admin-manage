package org.bumishi.admin.config;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.Session;
import org.springframework.session.hazelcast.config.annotation.web.http.EnableHazelcastHttpSession;
import org.springframework.session.web.http.CookieHttpSessionStrategy;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.session.web.http.HttpSessionStrategy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 由于这只是一个后台应用，没必要使用redis等其他存储来存储会话。如果你确实有需要可以自行变更
 * 这里使用Hazelcast存储会话,方便使用，不需要额外安装外部应用
 *
 * @author qiang.xie
 * @date 2016/11/1
 */
@Configuration
@EnableHazelcastHttpSession(maxInactiveIntervalInSeconds = 45 * 60)
public class SessionConfig {

    @Bean
    public HazelcastInstance embeddedHazelcast() {
        Config hazelcastConfig = new Config();
        return Hazelcast.newHazelcastInstance(hazelcastConfig);
    }

    @Bean
    public HttpSessionStrategy sessionStrategy() {
        return new HeaderAndCookieSessionStrategy(new CookieHttpSessionStrategy());
    }


    //header和cookie都支持session，方便对监控部分的页面进行权限保护
    class HeaderAndCookieSessionStrategy extends HeaderHttpSessionStrategy {

        CookieHttpSessionStrategy cookieHttpSessionStrategy;

        HeaderAndCookieSessionStrategy(CookieHttpSessionStrategy cookieHttpSessionStrategy) {
            this.cookieHttpSessionStrategy = cookieHttpSessionStrategy;
        }

        @Override
        public String getRequestedSessionId(HttpServletRequest request) {
            String headerToken = super.getRequestedSessionId(request);
            if (StringUtils.isBlank(headerToken)) {
                headerToken = cookieHttpSessionStrategy.getRequestedSessionId(request);
            }
            return headerToken;
        }

        @Override
        public void onNewSession(Session session, HttpServletRequest request, HttpServletResponse response) {
            super.onNewSession(session, request, response);
            cookieHttpSessionStrategy.onNewSession(session, request, response);
        }

        @Override
        public void onInvalidateSession(HttpServletRequest request, HttpServletResponse response) {
            super.onInvalidateSession(request, response);
            cookieHttpSessionStrategy.onInvalidateSession(request, response);
        }
    }


}
