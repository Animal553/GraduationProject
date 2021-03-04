package com.qianfeng.springboot.config;

import com.qianfeng.springboot.Realm.MyRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
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
//    public DefaultSessionManager createDefaultWebSessionManager(){
//        DefaultWebSessionManager defaultWebSessionManager = new DefaultWebSessionManager();
//        defaultWebSessionManager.setSessionIdCookie(null);
//
//        return defaultWebSessionManager;
//    }

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
