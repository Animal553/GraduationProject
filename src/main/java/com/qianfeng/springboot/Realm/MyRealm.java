package com.qianfeng.springboot.Realm;


import com.qianfeng.springboot.entity.Employee;
import com.qianfeng.springboot.service.EmployeeService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class MyRealm extends AuthorizingRealm {

    @Autowired
    private EmployeeService employeeService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String email = authenticationToken.getPrincipal().toString();

        Employee employee = employeeService.getEmployeeByEmail(email);
        System.out.println("认证完成===>>>>>>"+employee);
        if (employee==null){
            return null;
        }

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(employee.getEmail(),employee.getPassword(),getName());
        return info;
    }
}
