package com.qianfeng.springboot.config;

import com.qianfeng.springboot.Realm.MyRealm;
import org.apache.shiro.mgt.AbstractRememberMeManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.Cookie;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfig {


    @Bean
    public MyRealm createMyRealm(){
        MyRealm myRealm = new MyRealm();
        return myRealm;
    }

//    @Bean
//    public HashedCredentialsMatcher createHashedCredentialsMatcher(){
//        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
//        return matcher;
//    }

    @Bean
    public SecurityManager createSecurityManager(MyRealm myRealm){
        DefaultWebSecurityManager webSecurityManager = new DefaultWebSecurityManager();

        webSecurityManager.setRealm(myRealm);
        return webSecurityManager;
    }

    //设置shiro的会话时间
//    @Bean
//    public DefaultSessionManager createDefaultSessionManager(){
//        DefaultWebSessionManager defaultWebSessionManager = new DefaultWebSessionManager();
//        defaultWebSessionManager.setSessionIdCookie(null);
//
//        return defaultWebSessionManager;
//    }


//    /**
//     * 创建cookie
//     * @return
//     */
//    @Bean
//    public Cookie createCookie(){
//
//        SimpleCookie cookie = new SimpleCookie();
//
//        cookie.setHttpOnly(true);
//        cookie.setMaxAge(259200);
//
//        return cookie;
//    }
//
//    /**
//     * remember管理器
//     * @param createCookie
//     * @return
//     */
//    @Bean
//    public AbstractRememberMeManager createAbstractRememberMeManager(Cookie createCookie){
//        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
//        cookieRememberMeManager.setCookie(createCookie);
//        return cookieRememberMeManager;
//    }
//
    @Bean
    public ShiroFilterFactoryBean createShiroFilterFactoryBean(SecurityManager securityManager){

        ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();
        filterFactoryBean.setSecurityManager(securityManager);
        return filterFactoryBean;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

}
